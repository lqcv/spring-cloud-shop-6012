package com.newer.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newer.data.entity.Emp;
import com.newer.dao.EmpDao;
import org.springframework.stereotype.Service;

@Service
public class EmpServicelmpl extends ServiceImpl<EmpDao, Emp>
        implements EmpService{
}
