package com.github.dinglevin.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.dinglevin.mybatis.example.dataobject.UserDO;
import com.github.dinglevin.mybatis.example.mapper.UserMapper;
import com.github.dinglevin.mybatis.example.param.UserQueryParam;
import com.google.common.collect.Lists;

public class MyBatisExampleMain {
    public static void main(String[] args) {
        String mybatisConfig = "mybatis-config.xml";
        try (InputStream input = Resources.getResourceAsStream(mybatisConfig)) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
            try (SqlSession sqlSession = sessionFactory.openSession()) {
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                UserDO user = userMapper.selectUser(1);
                System.out.println("Find user: " + user);

                List<UserDO> users = userMapper.selectUserByName("John Doe");
                System.out.println("Find users by name: " + users);

                UserQueryParam queryParam = new UserQueryParam();
                queryParam.setEmailList(Lists.newArrayList("john.doe@example.com"));
                List<UserDO> users2 = userMapper.selectUserByParam(queryParam);
                System.out.println("Find users by name: " + users2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
