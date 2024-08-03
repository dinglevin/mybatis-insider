package com.github.dinglevin.mybatis.example.mapper;

import org.apache.ibatis.annotations.Param;

import com.github.dinglevin.mybatis.example.model.User;

public interface UserMapper {
    User selectUser(@Param("id") Integer id);
}
