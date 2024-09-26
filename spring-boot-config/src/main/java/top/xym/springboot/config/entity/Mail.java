package top.xym.springboot.config.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {
    private String to;
    private String subject;
    private String body;
}