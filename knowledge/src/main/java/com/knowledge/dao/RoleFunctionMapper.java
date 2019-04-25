package com.knowledge.dao;

import com.knowledge.entity.RoleFunction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleFunctionMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleFunction record);

    RoleFunction selectByPrimaryKey(String id);

    List<RoleFunction> selectAll();

    int updateByPrimaryKey(RoleFunction record);
}