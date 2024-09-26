//package top.xym.springboot.config.Controller;
//
//import jakarta.annotation.Resource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import top.xym.springboot.config.entity.Special;
//import top.xym.springboot.config.mapper.SpecialMapper;
//
//import java.util.List;
//
///**
// * @author 12862
// */
//@RestController
//public class SpecialController {
//    @Resource
//    private SpecialMapper specialMapper;
//
//    @GetMapping("/specials")
//    public List<Special> getSpecials() {
//        return specialMapper.findAll();
//    }
//}
