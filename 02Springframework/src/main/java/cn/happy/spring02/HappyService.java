package cn.happy.spring02;

/**
 * Created by Administrator on 2017/9/28.
 */
public class HappyService {
    private String info;
    private Integer age;
    public void work(){
        System.out.println("work"+info);
    }

    @Override
    public String toString() {
        return "HappyService{" +
                "info='" + info + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
