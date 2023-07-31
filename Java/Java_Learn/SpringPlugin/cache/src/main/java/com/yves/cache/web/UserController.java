package com.yves.cache.web;

import com.yves.cache.entity.User;
import com.yves.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HB
 * @date 7/9/2023 5:10 PM
 * @description TODO
 */
@Slf4j
@RestController
public class UserController {

    @Autowired(required = false)
    private UserService noCacheUserServiceImpl;

    @Autowired(required = false)
    private UserService springCacheUserServiceImpl;

    @GetMapping("user/{type}/{userId}")
    public User getUserById(@PathVariable("type") Integer type , @PathVariable("userId") Integer userId){

        log.info("类型{},查询编号{}",type,userId);
        switch (type){
            case 1:
                return noCacheUserServiceImpl.findById(userId);
            case 2:
                return springCacheUserServiceImpl.findById(userId);
            default:
                throw new RuntimeException("不存在该类型的方法");
        }
    }

    @PutMapping("user/{type}")
    public User updateUser(@PathVariable("type")Integer type,@RequestBody User user){
        switch (type){
            case 1:
                return noCacheUserServiceImpl.updateUser(user);
            case 2:
                return springCacheUserServiceImpl.updateUser(user);
            default:
                throw new RuntimeException();
        }
    }
}
