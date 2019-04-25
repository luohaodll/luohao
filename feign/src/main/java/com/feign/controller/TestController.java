package com.feign.controller;

import com.feign.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value="mq")
    public String sayHi(String name){
        String a =testService.insertUser();
        System.out.println("耗时"+a);
        return a;
    }
}
