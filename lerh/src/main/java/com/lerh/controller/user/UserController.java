package com.lerh.controller.user;/*
 @author LerH
 @DESCRIPTION 
 @create 2019/4/29
*/

import com.lerh.dao.UserMapper;
import com.lerh.entity.AjaxEntity;
import com.lerh.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="用户管理")
@RequestMapping(value="userController")
public class UserController {
    @Autowired
    private UserMapper userMapper;


    @ApiOperation(value="用户列表")
    @RequestMapping(value="userList")
    public AjaxEntity userList(){
        AjaxEntity ajaxEntity=new AjaxEntity();
        List<User> list=userMapper.selectAll();
        if (list.size()>0){
            ajaxEntity.setData(list);
            ajaxEntity.setStatus("true");

        }else{
            ajaxEntity.setStatus("false");
        }
        return ajaxEntity;
    }
}
