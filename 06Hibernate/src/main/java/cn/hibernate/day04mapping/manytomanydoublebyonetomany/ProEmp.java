package cn.hibernate.day04mapping.manytomanydoublebyonetomany;

/**
 * Created by Administrator on 2017/12/30.
 */
public class ProEmp {
    private Integer id;
    private Project pro;
    private Employee emp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getPro() {
        return pro;
    }

    public void setPro(Project pro) {
        this.pro = pro;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
}
