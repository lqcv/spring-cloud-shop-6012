package com.newer.web.control;


import com.newer.data.entity.Dept;
import com.newer.data.entity.Emp;
import com.newer.data.entity.Goods;
import com.newer.service.FeignProductService;
import com.newer.service.ProductEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//使用消费者启动openfeign
@RestController
//public class FeignConsumerControl implements ProductEmpService {
public class FeignConsumerControl implements FeignProductService {
//public class FeignConsumerControl{
    //服务消费者启动open-feign接口
    //FeignProductService继承ProductService
    @Autowired
    FeignProductService feignProductService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String feignConsumer() {
        StringBuilder sb=new StringBuilder();
        String res2 =  this.feignProductService
                .hello(new Goods(1,"电视机",2560.26));
        sb.append("绑定参数转换字符串："+res2);

        return sb.toString();
    }

//    @RequestMapping(value = "/feignEmp/{empno}", method = RequestMethod.GET)
//    public Emp selectByPrimaryKey(@PathVariable("empno")String empno){
//        Emp empty= this.feignProductService.findDeptById(Integer.valueOf(empno));
//        System.out.println("empty"+empty);
//        return empty;
//    }

    @RequestMapping(value = "/feign-emp", method = RequestMethod.GET)
   public List<Emp> feignEmp(@RequestParam("Deptid")String Deptid){
        List<Emp> empList = this.feignProductService.findDeptById(Integer.valueOf(Deptid));
        System.out.println("empList"+empList);
        return empList;
    }

    @Override
    public Goods findProductById(Integer pid) {
        return null;
    }

    @Override
    public String hello(String name) {
        return null;
    }

    @Override
    public Goods hello(int id, String name, double price) {
        return null;
    }

    @Override
    public String hello(Goods goods) {
        return null;
    }

    @Override
    public List<Emp> findDeptById(Integer Deptid) {
        return null;
    }
}

