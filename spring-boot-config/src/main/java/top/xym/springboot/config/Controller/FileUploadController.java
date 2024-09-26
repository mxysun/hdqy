//package top.xym.springboot.config.Controller;
//
//import jakarta.annotation.Resource;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import top.xym.springboot.config.Util.OssTemplate;
//@RestController
//@RequestMapping(value = "/file")
//public class FileUploadController {
//
//    @Resource
//    private OssTemplate ossTemplate;
//
//    @PostMapping("/oss")
//    public String ossUpload(MultipartFile file) {
//        return ossTemplate.ossUpload(file);
//    }
//}
