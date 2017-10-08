package cn.happy.spring01.printer;

import cn.happy.spring01.paper.Paper;
import cn.happy.spring01.ink.Ink;

/**
 * Created by Administrator on 2017/9/28.
 */
public class Print {
    //域属性
    private Ink ink;
    //域属性
    private Paper paper;
    //打印内容
    public void printSomething(){
        System.out.println("您正在使用"+ink.getColor()+"和"+paper.getContent()+"纸打印简历");
    }

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
