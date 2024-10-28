package top.xym.springboot.wenda.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.PutObjectResult;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.xym.springboot.wenda.config.OssConfig;
import top.xym.springboot.wenda.entity.Result;
import top.xym.springboot.wenda.entity.User;
import top.xym.springboot.wenda.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author 12862
 */
// 用户请求接口
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录接口
     * @param user 用户信息
     * @return Result
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 用户注册接口
     * @param user 用户信息
     * @return Result
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/{userId}")
    public User getUserByArticleUserId(@PathVariable Integer userId) {
        return userService.findUserByUserId(userId);
    }

    // 处理文件上传并保存头像到数据库
    @PostMapping("/uploadAvatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam("file") MultipartFile file, @RequestParam("userId") Integer userId) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("请选择要上传的文件", HttpStatus.BAD_REQUEST);
        }

        if (!file.isEmpty()) {
            try {
                // 保存文件到指定位置或进行其他处理
                file.transferTo(new File("./static/images"));
//                return "File uploaded successfully";
            } catch (IOException e) {
                e.printStackTrace();
//                return "File upload failed";
            }
        } else {
//            return "No file selected";
        }

        System.out.println("Received file: " + file.getOriginalFilename());
        System.out.println("Received user ID: " + userId);

        try {
            // 生成唯一的文件名
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            // 上传文件到阿里云 OSS
            OSS ossClient = OssConfig.getOssClient();
            PutObjectResult result = ossClient.putObject(OssConfig.getBucketName(), fileName, file.getInputStream());

            // 设置超时时间为 5 分钟（以毫秒为单位）
            long expirationTimeInMillis = 5 * 60 * 1000;
            Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeInMillis);
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(OssConfig.getBucketName(), fileName);
            request.setExpiration(expirationDate);

            // 获取可访问的 URL
            String url = ossClient.generatePresignedUrl(request).toString();

            // 更新用户头像路径到数据库
            int resultDB = userService.updateAvatarById(userId, url);
            if (resultDB > 0) {
                return new ResponseEntity<>("头像上传成功", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("头像上传失败", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("头像上传失败", HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            // 关闭 OSS 客户端
            OSS ossClient = OssConfig.getOssClient();
            ossClient.shutdown();
        }
    }

    @GetMapping("/api/getAvatarUrl/{userId}")
    public ResponseEntity<String> getAvatarUrl(@PathVariable Integer userId) {
        User user = userService.findUserByUserId(userId);
        if (user!= null && user.getAvatar()!= null) {
            return new ResponseEntity<>(user.getAvatar(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No avatar found for this user", HttpStatus.NOT_FOUND);
        }

    }

}
