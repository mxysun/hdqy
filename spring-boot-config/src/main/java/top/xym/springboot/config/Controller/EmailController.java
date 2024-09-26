//package top.xym.springboot.config.Controller;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import top.xym.springboot.config.entity.Mail;
//import top.xym.springboot.config.service.EmailService;
//
///**
// * @author 12862
// */
//@RestController
//@AllArgsConstructor
//public class EmailController {
//    private final EmailService emailService;
//
//    @PostMapping("/mail")
//    public void sendEmail(@RequestBody Mail mail) {
//        emailService.sendSimpleEmail(mail.getTo(), mail.getSubject(), mail.getBody());
//    }
//}