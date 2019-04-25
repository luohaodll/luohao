package com.knowledge.point;

import java.util.ArrayList;
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
 * @Title: TestStr
 * @ProjectName luohao
 * @Description: TODO
 * @author Lerh
 * @date 2019-4-2 9:41
 */
public class TestStr {
    public static void main(String[] args) {
        String  str= "漂亮:6,成熟:3,聪明:3,奉献:2,时尚:2,专家:2,优雅:2,甜美:1,温柔:1,英俊:1,可爱:1,得体:1,勇敢:1,意气风发:1,热情:1,谦虚:1,运筹帷幄:1,温和:1,浪漫:1,善良:1,独立:1,挺拔:1";
        List<String> list=new ArrayList<>();
        String[] s=str.split(",");
        for (int i = 0; i < 3; i++) {
           int lenth=s[i].indexOf(":");
           list.add(s[i].substring(0,lenth));
        }

    }
}
