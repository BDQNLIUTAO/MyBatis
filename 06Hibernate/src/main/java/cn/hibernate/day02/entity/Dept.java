package cn.hibernate.day02.entity;

/**
 * Created by Administrator on 2017/12/24.
 * 部门表
 */
public class Dept {
    private Integer deptno;  //部门编号
    private String dname;  //部门名称
    private String loc;   //部门位置

    public Dept() {
    }

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
