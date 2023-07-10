package com.yves.cache.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yves.cache.entity.User;
import com.yves.cache.mapper.UserMapper;
import com.yves.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author HB on 2023/7/6
 * TODO
 */
@Slf4j
@Service(value = "noCacheUserServiceImpl")
public class NoCacheUserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findById(Integer userId){
        log.info("没有使用缓存获取用户信息");
        return this.getById(userId);
    }

    @Override
    public User addUser(User user){
        this.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer userId){
        this.removeById(userId);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

}
