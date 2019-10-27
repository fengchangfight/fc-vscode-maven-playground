package com.fcvscodemvn.mybatis;

import java.io.IOException;
import java.io.InputStream;

import com.fcvscodemvn.mybatis.mapper.AuthorMapper;
import com.fcvscodemvn.mybatis.model.Article;
import com.fcvscodemvn.mybatis.model.Author;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisDemo {

    private static SqlSessionFactory sqlSessionFactory;

    public static void initMybatisConfig() {
        String resource = "com/fcvscodemvn/mybatis/mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initMybatisConfig();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AuthorMapper mapper = session.getMapper(AuthorMapper.class);
            Author author = mapper.findById(1L);
            String url = "www.jingjing.com";
            String title = "What you drink";
            Article article = new Article(url, title, author);
            System.out.println("before doing insert");
            mapper.insert2(article);
            session.commit();

            Long returnedId1 = article.getId();

            System.out.println(returnedId1);

            System.out.println(author);
        }
    }
}
