package com.lerh.service.impl;


import com.lerh.dao.UserMapper;
import com.lerh.entity.User;
import com.lerh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @Title: TestServiceImpl
 * @ProjectName ler
 * @Description: TODO
 * @author Lerh
 * @date 2018-12-28 9:21
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired(required = true)
    private UserMapper userMapper;

    @Override
    public String test() {
//       User user= userMapper.selectByPrimaryKey("1");

        return "";
    }
}
