package com.fcvscodemvn.mybatis.mapper;

import com.fcvscodemvn.mybatis.model.Author;

public interface AuthorMapper {
    Author findById(Long id);
}