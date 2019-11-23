package com.fcvscodemvn.clone;

import com.fcvscodemvn.model.Address;
import com.fcvscodemvn.model.Person;

/**
 * clone 相关姿势： https://www.geeksforgeeks.org/clone-method-in-java-2/
 */
public class FcClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address1 = new Address("China", "Shanghai", "202204");
        Person p1 = new Person("jet", 15, address1);
        Person p2 = (Person) p1.clone();
        p1.getAddress().setCode("333333");
        System.out.println(p1);
        System.out.println(p2);
    }
}