package com.lerh.shiro;

import com.lerh.entity.User;
import com.lerh.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
 * @Title: MyShiroRealm
 * @ProjectName luohao
 * @Description: TODO
 * @author Lerh
 * @date 2019-4-9 17:16
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    private static Logger logger= LoggerFactory.getLogger(ShiroRealm.class);



    /**
     * 配置权限 注入权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();

        //注入角色(查询所有的角色注入控制器）
       /* User user_role = userService.selectRoleByAccount(user.getUsername());
        List<Role> list_role=user.getRoles();
        for (Role role: list_role){
            authorizationInfo.addRole(role.getName());
        }*/
        //注入角色所有权限（查询用户所有的权限注入控制器）
       /* User user_function = userService.queryFunctionByUserId(user.getUsername());
        List<Function> list_function=user.getFunctions();
        for(Function function:list_function){
            authorizationInfo.addStringPermission(function.getCode());
        }*/

        return authorizationInfo;

    }
    /**
     * 用户验证
     * @param token 账户数据
     * @return
     * @throws AuthenticationException 根据账户数据查询账户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        User user = userService.selectByAccount(username);
        if (null == user) {
            return null;
        } else {
            if (password.equals(user.getPassword())) {

                SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
                return authorizationInfo;
            } else {
                return null;
            }
        }
    }
}
