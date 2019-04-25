package com.lerh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
 * @Title: LerhController
 * @ProjectName luohao
 * @Description: TODO
 * @author Lerh
 * @date 2019-4-11 14:42
 */
@Controller
@RequestMapping(value="lerh")
public class LerhController {
    @RequestMapping(value="render")
    public String render(String type){
        String h="";
        switch (type){
            case "baseData":
               h="page/dashboard.html";
            break;
            case "index":
                h="page/index.html";
            break;

        }
        return h;
    }
}
