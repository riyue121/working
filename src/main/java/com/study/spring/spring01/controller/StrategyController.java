package com.study.spring.spring01.controller;

import com.study.spring.spring01.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StrategyController {

    @Autowired
    private StrategyService strategyService;

    @RequestMapping("/test")
    public void testStrategyType(HttpServletRequest request) throws Exception {
        String type = request.getParameter("type");
        System.out.println(type);

        strategyService.handle(Integer.parseInt(type));
    }
}
