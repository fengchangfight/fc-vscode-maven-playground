package com.fcvscodemvn.mybatis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Article {
    private Long id;
    private String url;
    private String title;
    private Author author;

    public Article(String url, String title, Author author) {
        this.url = url;
        this.title = title;
        this.author = author;
    }

}