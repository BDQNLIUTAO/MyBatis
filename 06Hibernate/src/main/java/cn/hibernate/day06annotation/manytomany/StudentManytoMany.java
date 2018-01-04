package cn.hibernate.day06annotation.manytomany;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/1/2.
 * 学生表
 */
@Entity
@Table(name = "STUDENTMANYTOMANY")
public class StudentManytoMany {
    @Id
    @GenericGenerator(name = "stuid",strategy = "native")
    @GeneratedValue(generator = "stuid")
    private Integer stuid;  //学号
    @Column
    private String stuname;  //姓名
    @ManyToMany
    @Cascade(value = {CascadeType.SAVE_UPDATE})
    @JoinTable(name = "RSTUTER",joinColumns = {@JoinColumn(name = "stuid")},inverseJoinColumns = {@JoinColumn(name = "tid")})
    private Set<TeacherManytoMany> teacher=new HashSet<TeacherManytoMany>();

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Set<TeacherManytoMany> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<TeacherManytoMany> teacher) {
        this.teacher = teacher;
    }
}
