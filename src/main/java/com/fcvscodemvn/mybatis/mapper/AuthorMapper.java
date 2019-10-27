package com.fcvscodemvn.mybatis.mapper;

import com.fcvscodemvn.mybatis.model.Article;
import com.fcvscodemvn.mybatis.model.Author;

public interface AuthorMapper {
    Author findById(Long id);

    Long insert(Article article);

    Long insert2(Article article);
}