package com.github.dinglevin.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.dinglevin.mybatis.example.mapper.UserMapper;
import com.github.dinglevin.mybatis.example.model.User;

public class MyBatisExampleMain {
    public static void main(String[] args) {
        String mybatisConfig = "mybatis-config.xml";
        try (InputStream input = Resources.getResourceAsStream(mybatisConfig)) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                User user = userMapper.selectUser(1);
                System.out.println("Find user: " + user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
