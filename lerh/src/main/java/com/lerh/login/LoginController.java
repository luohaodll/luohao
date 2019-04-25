package com.lerh.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
        if ("luohao".equals(userName)&&"luohao".equals(passWord)){
            map.put("status",true);
        }else{
            map.put("status",false);
        }
        return map;
    }
    @RequestMapping(value="render")
    public String render(){
        return "page/index.html";
    }
}
