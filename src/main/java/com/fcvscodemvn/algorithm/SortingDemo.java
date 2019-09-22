package com.fcvscodemvn.algorithm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SortingDemo {
    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    private static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Mike", 25);
        Person p2 = new Person("Sam", 21);
        Person p3 = new Person("Will", 27);

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        System.out.println(personList);

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else if (o1.getAge() < o2.getAge()) {
                    return -1;
                }
                return 0;
            }
        });

        System.out.println(personList);
    }
}
