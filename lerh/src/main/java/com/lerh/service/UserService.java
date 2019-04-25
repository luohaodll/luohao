package com.lerh.service;


import com.lerh.entity.Role;
import com.lerh.entity.User;

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
 * @Title: UserService
 * @ProjectName ler
 * @Description: TODO
 * @author Lerh
 * @date 2019-1-2 11:09
 */
public interface UserService {


    User selectByAccount(String username);

    User selectRoleByAccount(String username);

    User queryFunctionByUserId(String username);

    List<Role> selectRolesById(String id);
}
