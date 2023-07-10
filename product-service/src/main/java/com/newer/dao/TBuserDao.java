package com.newer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.newer.data.entity.Dept;
import com.newer.data.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TBuserDao  extends BaseMapper<TbUser> {
}
