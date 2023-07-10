package com.newer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.newer.data.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao extends BaseMapper<Dept> {

}