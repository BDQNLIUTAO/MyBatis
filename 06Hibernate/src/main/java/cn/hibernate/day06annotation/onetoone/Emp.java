package cn.hibernate.day06annotation.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "Emponetoone")
public class Emp {
  @Id
  @GeneratedValue
  private Integer empno;
  @Column
  private String ename;
  @OneToOne
  @JoinColumn(name = "deno")
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
