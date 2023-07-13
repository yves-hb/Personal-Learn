package com.yves.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author HB on 2023/7/13
 * TODO 缓存设置
 */
@Configuration
public class MyCacheConfig {
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+ Arrays.asList(params).toString();
            }
        };
    }

    /**
     * 支持 lambda 表达式编写
     */
    @Bean("myKeyGeneratorOfLambda")
    public KeyGenerator keyGeneratorOfLambda(){
        return ( target,  method, params)-> method.getName()+ Arrays.asList(params).toString();
    }
}
