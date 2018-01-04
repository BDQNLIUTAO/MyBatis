package cn.hibernate.day06annotation.onetomany;

import javax.persistence.*;
@Entity
@Table(name = "emponetomany")
public class Emp {
  @Id
  @GeneratedValue
  private Integer empno;
  @Column
  private String ename;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "deptno")
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
