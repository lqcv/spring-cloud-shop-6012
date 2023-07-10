package com.newer.service;

import com.newer.data.entity.Dept;
import com.newer.data.entity.Emp;
import com.newer.data.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Open-Feign接口利用@FeignClient和@GetMapping/@PostMapping/
 * @ReqestMapping拼接指向服务提供者的URL路径：
 * http://product-service/findProductById/{pid}
 */

//@FeignClient("product-service")//配置服务提供者为product-service
public interface ProductService {
    //指定调用提供者的哪个方法
    //@FeignClient+@GetMapping 就是一个完整的请求路径
    // http://product-service/findProductById/{pid}
    @GetMapping("/findProductById/{pid}")
    public Goods findProductById(@PathVariable("pid") Integer pid);


    //openFeign绑定参数
    //服务提供者-》/hell1/name=牛耳教育
    @RequestMapping(value = "/hello1/{name}",method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name);

    //服务提供者-》/hell2/id=1&name=牛耳教育&pric=2002.1
    @RequestMapping(value = "/hello2/{id}/{name}/{price}",method = RequestMethod.GET)
    public Goods hello(@RequestHeader("id") int id,
                       @RequestParam("name") String name,
                       @RequestHeader("price") double price);

    //服务提供者-》/hell3/goods={id:1,name:电视机,price:2003.20}
    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody Goods goods);

    @GetMapping("/findDeptById/{Deptid}")
    public List<Emp> findDeptById(@PathVariable("Deptid") Integer Deptid);



}
