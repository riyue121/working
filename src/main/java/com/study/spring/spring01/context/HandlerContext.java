package com.study.spring.spring01.context;

import com.study.spring.spring01.handler.AbstractHandler;

import java.util.Map;

public class HandlerContext {

    private static Map<Integer, Class> handlerMap;

    public HandlerContext(Map<Integer, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(Integer type) throws Exception {
        Class clazz = this.handlerMap.get(type);

        if (clazz == null) {
            throw new RuntimeException("invalid parameter for type, the value is " + type);
        }

        return (AbstractHandler)SpringContextUtil.getBean(clazz);
    }
}
