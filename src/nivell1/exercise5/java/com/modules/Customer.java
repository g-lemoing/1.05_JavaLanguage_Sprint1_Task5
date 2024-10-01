package nivell1.exercise5.java.com.modules;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private int age;
    private String city;

    public Customer(String name, int age, String city){
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
