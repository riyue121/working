package com.study.spring.spring01.service.impl;

import com.study.spring.spring01.context.HandlerContext;
import com.study.spring.spring01.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    private HandlerContext handlerContext;
    @Override
    public void handle(int type) throws Exception{
        handlerContext.getInstance(type).doHandler(type);
    }
}
