package cn.hibernate.day04mapping.manytoone;


public class Emp {
  private Integer empno;
  private String ename;
  private Dept dept;

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public Integer getEmpno() {
    return empno;
  }

  public void setEmpno(Integer empno) {
    this.empno = empno;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

}
