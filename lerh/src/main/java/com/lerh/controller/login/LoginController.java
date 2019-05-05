package com.lerh.controller.login;

import com.lerh.shiro.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

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
 * @Title: LoginController
 * @ProjectName luohao
 * @Description: TODO
 * @author Lerh
 * @date 2019-4-9 14:09
 */
@Controller
@RequestMapping(value="login")
public class LoginController {
    Logger logger=Logger.getLogger("login");

    @RequestMapping(value="lerh")
    public ModelAndView lerh(){

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("page/login.html");
        return modelAndView;
    }
    @RequestMapping(value="login")
    @ResponseBody
    public Map<String, Object> login(String userName, String passWord){
        Map<String,Object> map=new HashMap<>();
        UsernamePasswordToken token=new UsernamePasswordToken(userName,passWord);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
            map.put("status",true);
        }catch (Exception e){
            logger.info("账号密码错误");
            map.put("status",false);
        }

        return map;
    }
    @RequestMapping(value="render")
    public String render(){
        return "page/index.html";
    }
}
