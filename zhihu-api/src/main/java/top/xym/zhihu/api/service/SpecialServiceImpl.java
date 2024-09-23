package top.xym.zhihu.api.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.xym.zhihu.api.entity.Special;
import top.xym.zhihu.api.mapper.SpecialMapper;
import top.xym.zhihu.api.service.SpecialService;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 12862
 */
@Service
public class SpecialServiceImpl implements SpecialService {
    @Resource
    public SpecialMapper specialMapper;

    @Override
    public List<Special> getAll() {
        List<Special> specials = specialMapper.selectAll();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        specials.forEach(special -> {
            //时间戳单位是秒，加上000变成毫秒，生成Date对象，再格式化
            String format = df.format(new Date(Long.parseLong(special.getUpdated() + "000")));
            special.setUpdated(format);
        });
        return specials;
    }

    // 格式化日期的方法
    private void formatUpdatedTimestamp(List<Special> items) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        items.forEach(item -> {
            // 将 Unix 时间戳从秒转换为毫秒并格式化为日期字符串
            String formattedDate = df.format(new Date(Long.parseLong(item.getUpdated() + "000")));
            item.setUpdated(formattedDate);
        });
    }
    @Override
    public List<Special> getByPage(int limit, int offset) {
        // 从数据库中获取分页的数据
        List<Special> items = specialMapper.selectByPage(limit, offset);
        // 调用时间戳格式化方法
        formatUpdatedTimestamp(items);
        return items;
    }
}

/*
这段代码定义了一个名为SpecialServiceImpl的服务类，它实现了SpecialService接口。在这个服务中，@Service注解表明这是一个Spring的bean，用于依赖注入和基于接口的声明式事务管理。

specialMapper字段前的@Resource注解不是Spring的标准，可能是使用了第三方库如Apache Commons或Spring AOP的工具，表示对SpecialMapper这个DAO层的依赖。通常情况下，在Spring中我们更倾向于使用@Autowired注解来完成自动装配。

getAll方法是从specialMapper获取所有特殊信息，然后通过自定义日期格式将其更新时间字段格式化。在实际操作数据库之前，将时间戳转换成了Date对象并进行了格式化。

getByPage方法未提供具体的实现，返回的是空列表。这是因为在默认情况下，Spring Data JPA或MyBatis会处理分页查询，如果需要使用这些库，这里应该会有一个对应的SQL查询。
 */
