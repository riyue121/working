package com.study.spring.spring01.service;

import com.study.spring.spring01.Spring01Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Spring01Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StrategyServiceTest {

    @Autowired
    private StrategyService strategyService;

    @Test
    public void doHandleTest() throws Exception {
        int type = 1;
        strategyService.handle(type);
    }
}
