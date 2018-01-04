package cn.happy.day12validator;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/7.
 */
public class UserInfo {
    //0-100之间
    @Min(value = 0,message = "最低分数不能小于0")
    @Max(value = 100,message = "最高分数不能大于100")
    private Integer score;
    //手机号码不能为空，必须是以1开头，第二位 3 4 5 6 7 8 9 ，最后9位随意
    @NotEmpty(message = "手机号码不能为空")
    @Pattern(regexp = "^1[3456789]\\d{9}$",message = "手机格式不正确")
    private String phone;
    //不能为空
    //必须是6个字符以上
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 6,message = "用户名必须大于6个字符")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
