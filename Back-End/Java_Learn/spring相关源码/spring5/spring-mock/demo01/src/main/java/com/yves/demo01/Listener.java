package com.yves.demo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author HB on 2023/7/4
 * TODO 时间监听者
 */
@Component
public class Listener {

    Logger log = LoggerFactory.getLogger(Listener.class);

    @EventListener
    public void listen(Date date){
        log.info("订阅接收时间: {}",date);
    }
}
