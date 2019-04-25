package com.knowledge.controller;

import com.knowledge.dao.UserMapper;
import com.knowledge.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class RabbitMQController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/mq")
     public String insertUser(){
         Long start=System.currentTimeMillis();

              User user=new User();
              user.setId(String.valueOf(122222));
              user.setName("luohao");
              user.setCreatetime(new Date());
             userMapper.insert(user);


        /* for (User user:list) {
             userMapper.insert(user);
         }*/
         Long end=System.currentTimeMillis();
         String a=String.valueOf(end-start);
         System.out.println("耗时"+a);
         return a;
     }
}
