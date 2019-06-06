package com.study.spring.spring01.handler.impl;

import com.study.spring.spring01.annotations.HandlerType;
import com.study.spring.spring01.handler.AbstractHandler;
import org.springframework.stereotype.Component;

@Component
@HandlerType(value = 3)
public class OfflineHandler extends AbstractHandler {
    @Override
    public void doHandler(Integer type) {
        System.out.println("offline handler deal with the type " + type);
    }
}
