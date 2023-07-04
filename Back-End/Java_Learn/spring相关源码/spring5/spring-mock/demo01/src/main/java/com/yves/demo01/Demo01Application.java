package com.yves.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

/**
 * @author HB
 * @date 7/2/2023 6:36 PM
 * @description TODO
 */
@SpringBootApplication
public class Demo01Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo01Application.class, args);

//        System.out.println(context.getMessage("hi", null, Locale.CHINA));

        /*try {
            Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
            for (Resource resource : resources) {
                System.out.println(resource);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*System.out.println(context.getEnvironment().getProperty("java_home"));
        System.out.println(context.getEnvironment().getProperty("server.port"));*/
        context.publishEvent(new Date());
    }
}
