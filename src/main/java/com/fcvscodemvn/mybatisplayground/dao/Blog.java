package com.fcvscodemvn.mybatisplayground.dao;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
public class Blog {
    private Long id;
    private String title;
    private String author;
}