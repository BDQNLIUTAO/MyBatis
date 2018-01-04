package cn.hibernate.day04mapping.manytomanydoublebyonetomany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Happy on 2017-09-26.
 */
//员工实体
public class Employee {
    private Integer empid;  //员工编号
    private String empname;  //员工姓名
    private Set<Project> projects = new HashSet<Project>();  //植入项目集合

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }
}
