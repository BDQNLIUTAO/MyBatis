package cn.happy.entity;

/**
 * Created by Administrator on 2017/9/14.
 */
public class UserInfo {
    private Integer id;  //用户id
    private String name;  //用户姓名
    private String sex;   //用户性别
    private int age;    //年龄

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
