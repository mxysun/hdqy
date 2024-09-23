package top.xym.springboot.thymeleaf.Controller;
//Spring Boot 控制器，用于返回Thymeleaf页面
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 12862
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        //将“message”属性传递到视图
        model.addAttribute("message",
                "Hello, World，Thymeleaf!");
        //返回视图名称“hello”
        return "hello";
    }
}
/*
@Controller：声明这是一个Spring MVC控制器；
Model：Spring MVC提供的对象，用于将数据传递到前端页面；
@GetMapping（“/hello”）：映射 /hello 请求到该方法；
model.addAttribute("message", "Hello,Thymeleaf!")：将 message 变量传递给前端页面；
返回 hello 视图名称（即 hello.html 页面）
 */
