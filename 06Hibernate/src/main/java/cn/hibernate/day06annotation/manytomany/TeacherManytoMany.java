package cn.hibernate.day06annotation.manytomany;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/1/2.
 * 教师表
 */
@Entity
@Table(name = "TEACHERMANYTOMANY")
public class TeacherManytoMany {
    @Id
    @GenericGenerator(name = "tid",strategy = "native")
    @GeneratedValue(generator = "tid")
    private Integer tid;  //教师编号
    @Column
    private String tname;  //教师姓名
    @ManyToMany
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name = "RSTUTER",joinColumns = {@JoinColumn(name = "tid")},inverseJoinColumns = {@JoinColumn(name = "stuid")})
    private Set<StudentManytoMany> student=new HashSet<StudentManytoMany>();

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Set<StudentManytoMany> getStudent() {
        return student;
    }

    public void setStudent(Set<StudentManytoMany> student) {
        this.student = student;
    }
}
