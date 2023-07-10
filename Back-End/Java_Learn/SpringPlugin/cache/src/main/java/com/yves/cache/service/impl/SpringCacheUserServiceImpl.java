package com.yves.cache.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yves.cache.entity.User;
import com.yves.cache.mapper.UserMapper;
import com.yves.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author HB
 * @date 7/9/2023 5:19 PM
 * @description TODO
 */
@Slf4j
@Service(value = "springCacheUserServiceImpl")
public class SpringCacheUserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * Cacheable注解作用: 添加一个缓存容器(cache) , 容器名为user , 缓存key为方法参数
     * 运行机制: 在调用方法时首先查询名为user的缓存容器是否存在 , 不存在则创建
     *          查询是否存在key=userId的数据
     *          如果有 , 则从缓存中调取 ,
     *          如果没有 , 则执行方法并把结果放入名为user的cache中
     * 参数详解:
     *          1. value : "容器名" or {"","",...} , 可以指定结果存入的缓存容器名 , 可同时指定多个
     *          2. key : 缓存的key , 可以为空 , 如果指定需按照SqEL表达式编写 , 如果不指定则按照方法所有参数进行组合
     */
    @Override
    @Cacheable(value = "user")
    public User findById(Integer userId) {
        log.info("使用SpringCache获取用户信息");
        return this.getById(userId);
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    @CachePut(value = "user", key = "#user.userId")
    public User updateUser(User user) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>().eq(User::getUserId, user.getUserId());
        this.update(user,updateWrapper);
        return user;
    }
}
