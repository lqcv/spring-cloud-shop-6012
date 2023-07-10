package com.newer;

import com.newer.dao.TBuserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductMybatisplusApplicationTests {

    @Autowired
    TBuserDao tBuserDao;
    @Test
    void contextLoads() {
        tBuserDao.selectList(null).forEach(System.out::println);
    }

}
