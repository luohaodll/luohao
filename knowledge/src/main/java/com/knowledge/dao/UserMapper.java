package com.knowledge.dao;

import com.knowledge.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}