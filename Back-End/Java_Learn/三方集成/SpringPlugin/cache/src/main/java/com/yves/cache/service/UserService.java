package com.yves.cache.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yves.cache.entity.User;
import com.yves.cache.mapper.UserMapper;

/**
 * @author HB on 2023/7/6
 * TODO 用户操作
 */
public interface UserService extends IService<User> {

    User findById(Integer userId);

    User addUser(User user);

    void deleteUser(Integer userId);
}
