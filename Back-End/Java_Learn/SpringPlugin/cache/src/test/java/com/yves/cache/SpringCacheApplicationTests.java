package com.yves.cache;

import com.yves.cache.entity.User;
import com.yves.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author HB on 2023/7/6
 * TODO
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringCacheApplicationTests {

    @Autowired(required = false)
    private UserService noCacheUserService;

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("bbb");
        noCacheUserService.addUser(user);
        log.info("User added: {}" , user);
    }

    @Test
    public void findUserById(){
        User byId = noCacheUserService.findById(1);
        log.info("User found: {}", byId);
    }
}
