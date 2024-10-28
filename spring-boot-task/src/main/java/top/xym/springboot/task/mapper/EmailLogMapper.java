package top.xym.springboot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xym.springboot.task.entity.EmailLog;

@Mapper
public interface EmailLogMapper extends BaseMapper<EmailLog> {
    void setSubject(EmailLog emailLog);

    void setContent(EmailLog emailLog);

    void setStatus(EmailLog emailLog);
}
