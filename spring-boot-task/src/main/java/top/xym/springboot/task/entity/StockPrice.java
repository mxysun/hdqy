package top.xym.springboot.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("stock_price")
public class StockPrice {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private LocalDateTime updateTime;

    // 设置价格时进行处理
    public void setPrice(Double price) {
        BigDecimal bd = new BigDecimal(price);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.price = bd.doubleValue();
    }

    // 获取价格时直接返回
    public Double getPrice() {
        return price;
    }

}
