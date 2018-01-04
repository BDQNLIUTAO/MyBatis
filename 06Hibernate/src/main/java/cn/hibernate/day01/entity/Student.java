package cn.hibernate.day01.entity;

/**
 * Created by Administrator on 2017/12/21.
 * 学生类
 */
public class Student {
    private Integer sid;  //主键 编号
    private String sname; //学生姓名
    private Integer sage;  //学生年龄

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }
}
