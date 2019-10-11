package com.fcvscodemvn.mybatis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {
    private Long id;
    private String name;
    private Integer sex;
}