package com.fcvscodemvn.streamapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtilDemo {

    @Setter
    @Getter
    @NoArgsConstructor
    static class InnerPerson {
        String name;
        Integer age;

        public InnerPerson(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " is " + age + "years old";
        }
    }

    public static void main(String[] args) {
        List<InnerPerson> people = new ArrayList<InnerPerson>();

        people.add(new InnerPerson("Sam", 22));
        people.add(new InnerPerson("Mike", 20));
        people.add(new InnerPerson("Jim", 10));
        people.add(new InnerPerson("William", 30));

        System.out.println(people);

        // sort
        Comparator<InnerPerson> comparator = Comparator.comparing(InnerPerson::getAge);

        List<InnerPerson> sortedResult = people.stream().sorted(comparator.reversed()).collect(Collectors.toList());

        System.out.println(sortedResult);

    }
}
