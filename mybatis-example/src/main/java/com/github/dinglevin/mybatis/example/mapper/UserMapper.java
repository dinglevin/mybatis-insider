package com.github.dinglevin.mybatis.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.dinglevin.mybatis.example.dataobject.UserDO;
import com.github.dinglevin.mybatis.example.param.UserQueryParam;

public interface UserMapper {
    UserDO selectUser(@Param("id") Integer id);

    @Select("SELECT * FROM users WHERE name = #{name}")
    List<UserDO> selectUserByName(@Param("name") String name);

    List<UserDO> selectUserByParam(UserQueryParam queryParam);
}
