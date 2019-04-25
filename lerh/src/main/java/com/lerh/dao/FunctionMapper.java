package com.lerh.dao;

import com.lerh.entity.Function;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FunctionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Function record);

    Function selectByPrimaryKey(String id);

    List<Function> selectAll();

    int updateByPrimaryKey(Function record);
}