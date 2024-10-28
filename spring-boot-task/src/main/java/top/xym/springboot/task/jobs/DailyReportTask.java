//package top.xym.springboot.task.jobs;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import top.xym.springboot.task.service.MailService;
//
//import java.time.LocalDate;
//
//@Component // 要被定时任务扫到
//@AllArgsConstructor
//@Slf4j
//public class DailyReportTask {
//    public final MailService mailService;
//
//    @Scheduled(cron = "0 00 17 * * ?")
//    public void sendReport() {
//        String report = "这是每日报表的内容";
//        mailService.sendMail("1286280961@qq.com", "每日数据报告", report);
//        log.info("报表已生成，并发送邮件完成！{}", LocalDate.now());
//    }
//}
