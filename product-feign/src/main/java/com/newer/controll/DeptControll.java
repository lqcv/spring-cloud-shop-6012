package com.newer.controll;

import com.newer.data.entity.Dept;
import com.newer.data.entity.Emp;
import com.newer.data.entity.Goods;
import com.newer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptControll {

//    @Autowired
//    ProductService productService;//绑定Feign Service
//
//    @GetMapping("/dept/{Deptid}")
//    public List<Emp> order(@PathVariable("Deptid")Integer Deptid){
//       List<Emp> deptList= this.productService.findDeptById(Deptid);
//        System.out.println("deptList："+deptList);
//       return deptList;
//    }
}
