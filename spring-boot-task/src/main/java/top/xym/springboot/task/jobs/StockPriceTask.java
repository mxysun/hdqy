//package top.xym.springboot.task.jobs;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import top.xym.springboot.task.entity.StockPrice;
//import top.xym.springboot.task.mapper.StockPriceMapper;
//
//import java.time.LocalDateTime;
//import java.util.Random;
//
///**
// * @author 12862
// * 定时任务： 每个10秒更新一次股票价格，并持久化到数据库
// */
//@Component
//@AllArgsConstructor
//@Slf4j
//public class StockPriceTask {
//    private final StockPriceMapper stockPriceMapper;
//
//    private final Random random = new Random();
//
//    @Scheduled(fixedRate = 10000)
//    public void updateStockPrice() {
//        double price = 100 + random.nextDouble() *50;
//
//        StockPrice stockPrice = new StockPrice();
//        stockPrice.setPrice(price);
//        stockPrice.setName("小米");
//        stockPrice.setUpdateTime(LocalDateTime.now());
//
//        stockPriceMapper.insert(stockPrice);
//        log.info("股票价格已更新：{}，时间：{}",price, LocalDateTime.now());
//    }
//}
