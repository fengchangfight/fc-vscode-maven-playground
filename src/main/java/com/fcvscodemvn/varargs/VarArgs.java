package com.fcvscodemvn.varargs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public final class VarArgs {

    private static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Person> ll = new ArrayList<>();
        ll.add(new Person("Sam", 15));
        ll.add(new Person("Mike", 12));
        List<String> b = ll.stream().map(r -> r.getName()).collect(Collectors.toList());
        printVararg(b.toArray(new String[b.size()]));
    }

    private static void printVararg(String... ss) {
        for (String s : ss) {
            System.out.println(s);
        }
    }
}
