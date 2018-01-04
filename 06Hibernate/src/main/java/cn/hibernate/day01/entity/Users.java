package cn.hibernate.day01.entity;

/**
 * Created by Administrator on 2017/12/23.
 * 用户表
 */
public class Users {
    private Integer id;   //用户编号
    private String name;  //用户名
    private String password;  //用户密码
    private String telephone;  //电话
    private String username;   //姓名
    private String isadmin;   //是否是管理员

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }
}
