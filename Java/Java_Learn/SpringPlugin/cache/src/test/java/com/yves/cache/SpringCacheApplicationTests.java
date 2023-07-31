package com.yves.cache;

import com.yves.cache.entity.User;
import com.yves.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HB on 2023/7/6
 * TODO
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringCacheApplicationTests {

    @Resource(name = "noCacheUserServiceImpl")
    private UserService noCacheUserService;

    @Resource
    private CacheManager cacheManager;

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

    @Test
    public void findUser(){
        Cache user = cacheManager.getCache("user");
        Object nativeCache = user.getNativeCache();
        System.out.println(nativeCache.getClass());
        ConcurrentHashMap<Integer,User> concurrentMap =(ConcurrentHashMap<Integer,User>) nativeCache;
        User user1 = concurrentMap.get(1);
        log.info("User found: {}", user1);
    }
}
