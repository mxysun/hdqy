package top.xym.springboot.database;

/**
 * @author 12862
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//它开启了自动配置、组件扫描等功能，使得 Spring Boot 能够自动探测和配置项目所需的各种组件和服务。
@SpringBootApplication
public class Application {
    public static void main (String[] args) {
        // 这行代码用于启动 Spring Boot 应用程序
        // Application.class是当前类的引用，告诉 Spring Boot 从这个主配置类开始启动应用程序。
        // args是命令行参数，可以在启动应用程序时传入一些参数来配置应用程序的行为。
        SpringApplication.run(Application.class, args);
    }
}