package com.technews.testModel;

import java.util.Objects;

public class Demo {
    private String name;  // Private Variables
    private int age;

    public String getName() {  // Getters and Setters
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {  // equals() and hashcode() methods
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return age == demo.age && Objects.equals(name, demo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {  // toString() method
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Demo(String name, int age) {  // Constructor
        this.name = name;
        this.age = age;


    }
}
