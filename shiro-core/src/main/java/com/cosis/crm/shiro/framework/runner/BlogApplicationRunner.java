package com.cosis.crm.shiro.framework.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 程序启动后通过ApplicationRunner处理一些事务
 *
 */
@Slf4j
@Component
public class BlogApplicationRunner implements ApplicationRunner {

    @Value("${server.port}")
    private int port;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        log.info("程序部署完成，访问地址：http://localhost:" + port);
    }
}
