package com.knowledge.dao;

import com.knowledge.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(String id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);
}