package cn.happy.spring16autowire;

/**
 * Created by Administrator on 2017/10/7.
 */
public class Car {
    private String brand;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
