package top.xym.zhihu.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 12862
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.xym.zhihu.api.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
这段代码是一个典型的Spring Boot应用启动类。首先，
@SpringBootApplication注解标记该类为Spring Boot应用程序入口点，
这意味着它包含了Spring MVC、Spring Data JPA以及Spring Boot自动配置的功能。
@MapperScan注解的作用是扫描指定包路径下的Mapper接口，通常用于MyBatis框架集成，
这里basePackages = {"top.xym.zhihu.api.mapper"}表示会查找位于
top.xym.zhihu.api.mapper包及其子包下的Mapper接口并注册到Spring容器中，以便IoC容器能够管理它们。
public static void main(String[] args)是标准的Java程序主入口，
当运行这个类时，Spring Boot会初始化应用上下文（ApplicationContext），
然后调用SpringApplication.run()方法开始应用的生命周期，接收命令行参数args。
简而言之，这段代码设置了Spring Boot的应用环境，并配置了MyBatis的Mapper接口扫描，最终启动了整个Spring Boot应用。

 */