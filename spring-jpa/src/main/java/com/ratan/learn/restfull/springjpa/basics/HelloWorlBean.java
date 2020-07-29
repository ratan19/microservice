package com.ratan.learn.restfull.springjpa.basics;

import java.util.Objects;

public class HelloWorlBean {

    private String name;
    private int age;

    public String getName() {
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

    public HelloWorlBean(){

    }

    public HelloWorlBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloWorlBean that = (HelloWorlBean) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "HelloWorlBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    protected int x = 0;
}
