package cn.hibernate.day06annotation.onetoone;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/12/28.
 */
@Entity
@Table(name = "Deptoneone")
public class Dept {
    @Id
    @GeneratedValue
    private Integer deptno;
    @Column
    private String dname;
    @OneToOne(mappedBy = "dept",cascade = CascadeType.ALL)
    private Emp emp;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
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
}
