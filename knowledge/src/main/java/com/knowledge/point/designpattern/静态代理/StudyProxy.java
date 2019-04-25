package com.knowledge.point.designpattern.静态代理;

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
 * @Title: StudyProxy
 * @ProjectName luohao
 * @Description: 静态代理类
 * @author Lerh
 * @date 2019-4-1 9:39
 */
public class StudyProxy implements Study{
    private Study study;
    public StudyProxy(Study study){
        this.study=study;
    }
    @Override
    public void study() {
        System.out.println("before");
        study.study();
        System.out.println("after");
    }
}
