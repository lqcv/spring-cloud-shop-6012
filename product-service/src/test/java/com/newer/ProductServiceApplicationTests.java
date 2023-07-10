package com.newer;

import com.newer.dao.EmpDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    EmpDao empDao;

    @Test
    void contextLoads() {
//        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
//        wrapper.eq("DEPTNO","10");
//        empDao.selectList(wrapper).forEach(System.out::println);
//    empDao.selectList(null).forEach(System.out::println);
    }

}
