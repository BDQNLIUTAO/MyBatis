package cn.happy.spring04aop.entity;

/**
 * Created by Administrator on 2017/9/30.
 */
public class User {
    private Integer id;   //用户id
    private String username;  //用户名
    private String password;  //密码
    private String email;  //电子邮件

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
