package com.fcvscodemvn.lombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Person {
    private String name;
    private Integer age;
}