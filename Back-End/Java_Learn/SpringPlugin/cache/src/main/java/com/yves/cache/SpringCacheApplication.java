package com.yves.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author HB on 2023/7/6
 * TODO
 */
@SpringBootApplication
@MapperScan("com.yves.cache.mapper")
@EnableCaching
public class SpringCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApplication.class, args);
        System.out.println("启动成功!");
    }
}
