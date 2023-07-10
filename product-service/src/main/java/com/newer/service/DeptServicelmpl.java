package com.newer.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newer.data.entity.Dept;
import com.newer.dao.DeptDao;
import org.springframework.stereotype.Service;

@Service
public class DeptServicelmpl extends ServiceImpl<DeptDao, Dept>
        implements DeptService{
}
