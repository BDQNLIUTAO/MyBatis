package cn.hibernate.day06annotation.base;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/1/2.
 */
@Entity
@Table(name = "Dept")
public class Dept {
    @Id
    @GeneratedValue
    private Integer deptno;
    @Column
    private String dname;

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
}
