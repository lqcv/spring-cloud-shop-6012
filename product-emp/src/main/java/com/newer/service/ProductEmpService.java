package com.newer.service;

import com.newer.data.entity.Emp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient("product-service")//配置服务提供者为product-service
public interface ProductEmpService {
    @GetMapping("/findEmpById/{empno}")
    public Emp findDeptById(@PathVariable("empno") Integer empno);
}
