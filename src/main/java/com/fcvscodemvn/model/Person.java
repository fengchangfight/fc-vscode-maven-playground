package com.fcvscodemvn.model;

import lombok.Data;

@Data
public class Person implements Cloneable {
    private String name;
    private Integer age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Object clone() throws CloneNotSupportedException {
        Person newP = (Person) super.clone();

        // deep copy
        // newP.setAddress(new Address(newP.getAddress()));

        return newP;
    }
}