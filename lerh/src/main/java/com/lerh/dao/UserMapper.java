package com.lerh.dao;

import com.lerh.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    int insert(User record);

    List<User> selectAll();

    User selectByUsername(String username);
}