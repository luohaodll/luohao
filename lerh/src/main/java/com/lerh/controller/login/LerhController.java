package com.lerh.controller.login;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@Api(tags="lerh菜单")
public class LerhController {
    @RequestMapping(value="render",method= RequestMethod.GET)
    @ApiOperation(value="菜单跳转")
    public String render(@RequestParam String type){
        String view="";
        switch (type){
            case "dashboard":
                view="page/dashboard.html";
            break;
            case "index":
                view="page/index.html";
            break;
            case "person":
                view="page/index.html";
                break;
            case "content_paste":
                view="page/tables.html";
                break;
            case "library_books":
                view="page/typography.html";
                break;
            case "bubble_chart":
                view="page/icons.html";
                break;
            case "location_ons":
                view="page/map.html";
                break;
            case "notifications":
                view="page/notifications.html";
                break;
            case "language":
                view="page/rtl.html";
                break;
            case "unarchive":
                view="page/upgrade.html";
                break;
        }
        return view;
    }
}
