package com.study.spring.spring01.processor;

import com.google.common.collect.Maps;
import com.study.spring.spring01.annotations.HandlerType;
import com.study.spring.spring01.context.HandlerContext;
import com.study.spring.spring01.utils.ClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String SCAN_PACKAGE = "com.study.spring.spring01.handler";
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<Integer, Class> handlerMap = Maps.newHashMap();
        ClassScanner.scan(SCAN_PACKAGE, HandlerType.class).stream().forEach(clazz -> {
            int type = ((HandlerType)clazz.getAnnotation(HandlerType.class)).value();
            handlerMap.put(type, clazz);
        });

        HandlerContext handlerContext = new HandlerContext(handlerMap);

        configurableListableBeanFactory.registerSingleton(HandlerContext.class.getName(), handlerContext);
    }
}
