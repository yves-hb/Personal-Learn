package com.yves.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HB on 2023/7/6
 * TODO
 */
@SpringBootApplication
@MapperScan("com.yves.cache.mapper")
public class SpringCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApplication.class, args);
        System.out.println("启动成功!");
    }
}
