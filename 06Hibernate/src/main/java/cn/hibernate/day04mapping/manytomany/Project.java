package cn.hibernate.day04mapping.manytomany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Happy on 2017-09-26.
 * 工程实体
 */
public class Project {
    private Integer proid;
    private String proname;
    private Set<Employee> employees=new HashSet<Employee>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

}
