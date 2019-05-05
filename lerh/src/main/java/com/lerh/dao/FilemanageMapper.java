package com.lerh.dao;

import com.lerh.entity.Filemanage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FilemanageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Filemanage record);

    Filemanage selectByPrimaryKey(String id);

    List<Filemanage> selectAll();

    int updateByPrimaryKey(Filemanage record);
}