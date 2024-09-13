package top.xym.springboot.thymeleaf;

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
        model.addAttribute("message", "Hello, World，Thymeleaf!");
        //返回视图名称“hello”
        return "hello";
    }
}
