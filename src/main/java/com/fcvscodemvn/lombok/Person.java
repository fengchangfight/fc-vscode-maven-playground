package com.fcvscodemvn.lombok;

import lombok.Builder;
import lombok.ToString;

@Builder(builderMethodName = "fuckingBuilder")
@ToString
public class Person {
    private String name;
    private Integer age;
}