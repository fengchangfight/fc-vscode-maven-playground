package com.fcvscodemvn.lombok;

public class BuilderDemo {
    public static void main(String[] args) {
        Person p = Person.fuckingBuilder().age(10).name("Jet").build();
        System.out.println(p);
    }
}