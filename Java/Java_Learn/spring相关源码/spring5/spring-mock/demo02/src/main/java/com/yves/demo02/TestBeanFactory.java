package com.yves.demo02;

import ch.qos.logback.core.joran.action.ActionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HB on 2023/7/5
 * TODO BeanFactory测试类
 */
public class TestBeanFactory {
    public static void main(String[] args) {
        // 这是BeanFactory最常用的实现类
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 刚创建的 DefaultListableBeanFactory 对象中并没有 bean 的存在 , 需要主动添加bean的定义
        // bean的定义: 描述Bean的属性(class , scope , 初始化方法 , 销毁方法...) ,
        // 由 DefaultListableBeanFactory 来生成真正的bean对象 (控制反转 | 依赖注入)

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope(BeanDefinition.SCOPE_SINGLETON).getBeanDefinition();
        beanFactory.registerBeanDefinition("config", beanDefinition);

        // 给 beanFactory 添加一些常用的后处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        // 获取添加的后处理器 , 后处理器的主要功能补充了一些有关bean的定义 , 解析Configuration\Bean等注解
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(beanFactoryPostProcessor -> {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        });

        // bean后处理器 , 针对 bean 的生命周期的各个阶段提供扩展 , 例如@Resource @Autowired
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().stream()
                .sorted(beanFactory.getDependencyComparator())
                .forEach(beanPostProcessor -> {
                    System.out.println(beanPostProcessor);
                    beanFactory.addBeanPostProcessor(beanPostProcessor);
                });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        // 预先创建所有单例对象
        beanFactory.preInstantiateSingletons();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(beanFactory.getBean(Bean1.class).getBean2());
    }

    @Configuration
    static class Config {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }

    static class Bean1 {
        private static final Logger log = LoggerFactory.getLogger(Bean1.class);

        public Bean1() {
            log.info("构造bean1");
        }

        @Autowired
        private Bean2 bean2;

        public Bean2 getBean2() {
            return bean2;
        }
    }

    static class Bean2 {
        private static final Logger log = LoggerFactory.getLogger(Bean2.class);

        public Bean2() {
            log.info("构造bean2");
        }

        @Autowired
        private Bean1 bean1;

        public Bean1 getBean1() {
            return bean1;
        }
    }
}
