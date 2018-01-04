package cn.hibernate.day06annotation.onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/12/28.
 */
@Entity
@Table(name = "deptonetomany")
public class Dept {
    @Id
    @GeneratedValue
    private Integer deptno;
    @Column
    private String dname;
    @OneToMany(mappedBy = "dept",cascade =CascadeType.ALL )
    private Set<Emp> emps=new HashSet<Emp>();

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
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
