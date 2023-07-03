package com.yves.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author HB
 * @date 7/2/2023 6:36 PM
 * @description TODO
 */
public class Demo01Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo01Application.class, args);
        System.out.println(context);
    }
}
