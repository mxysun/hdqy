package top.xym.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

/**
     * @author 12862
     */
    @ImportResource(locations = {"classpath:beans.xml"})
    @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
    @RestController
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }
//        @GetMapping("/hello")
//        public String hello(String name) {
//            return "Hello, " + name;
//        }

