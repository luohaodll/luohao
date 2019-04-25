package com.lerh.service.impl;


import com.lerh.dao.UserMapper;
import com.lerh.entity.Role;
import com.lerh.entity.User;
import com.lerh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 *          ┌─┐       ┌─┐
 *       ┌──┘ ┴───────┘ ┴──┐
 *       │                 │
 *       │       ───       │
 *       │  ─┬┘       └┬─  │
 *       │                 │
 *       │       ─┴─       │
 *       │                 │
 *       └───┐         ┌───┘
 *           │         │
 *           │         │
 *           │         │
 *           │         └──────────────┐
 *           │                        │
 *           │                        ├─┐
 *           │                        ┌─┘
 *           │                        │
 *           └─┐  ┐  ┌───────┬──┐  ┌──┘
 *             │ ─┤ ─┤       │ ─┤ ─┤
 *             └──┴──┘       └──┴──┘
 *                 神兽保佑
 *                 代码无BUG!
 * @Title: UserServiceImpl
 * @ProjectName ler
 * @Description: TODO
 * @author Lerh
 * @date 2019-1-2 11:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByAccount(String username) {
        User user=userMapper.selectByUsername(username);
        return user;
    }

    @Override
    public User selectRoleByAccount(String username) {
        return null;
    }

    @Override
    public User queryFunctionByUserId(String username) {
        return null;
    }

    @Override
    public List<Role> selectRolesById(String id) {
        return null;
    }


}
