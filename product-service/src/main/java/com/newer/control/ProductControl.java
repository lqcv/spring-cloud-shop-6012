package com.newer.control;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.newer.dao.TBuserDao;
import com.newer.data.entity.Emp;
import com.newer.dao.EmpDao;
import com.newer.data.entity.Goods;
import com.newer.data.entity.TbUser;
import com.newer.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Slf4j
public class ProductControl implements ProductService {
//public class ProductControl {
    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/findProductById/{pid}")
    public Goods findProductById(@PathVariable("pid") Integer pid){
        Goods goods = new Goods(1001,"洗衣机",2005.26);
        return goods;
    }

    @Autowired
    EmpDao empDao;
    @GetMapping("/findDeptById/{Deptid}")
    public List<Emp> findDeptById(@PathVariable("Deptid") Integer Deptid){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("DEPTNO",Deptid);
        System.out.println("findDeptById打印："+empDao.selectList(wrapper));
        return empDao.selectList(wrapper);
    }

    @GetMapping("/findEmpById/{empno}")
    public Emp findEmpById(@PathVariable("empno") Integer empno){
     Emp empty= this.empDao.selectById(empno);
        return empty;
    }

        //使用openFeign绑定参数
//    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
//    public String hello(@RequestParam String name){
//        System.out.println("服务提供者product-service返回字符串："+name);
//        return "hello,"+name;
//    }
//
//    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
//    public Goods hello(@RequestHeader Integer id,@RequestParam String name,@RequestHeader Double price){
//        return new Goods(id,name,price);
//    }
//
//    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
//    public String hello(@RequestBody Goods goods){
//        return "hello,"+goods.getGoodsName()+","+goods.getGoodsPrice();
//    }

    @Override
    public String hello(@RequestParam("name") String name){
        System.out.println("服务提供者product-service返回字符串："+name);
        return "hello,"+name;
    }

    @Override
    public Goods hello(@RequestHeader("id") int id, @RequestParam("name") String name, @RequestHeader("price") double price){
        return new Goods(id,name,price);
    }

    @Override
    public String hello(@RequestBody Goods goods){
        return "hello,"+goods.getGoodsName()+","+goods.getGoodsPrice();
    }

    @Autowired
    TBuserDao tbUserdao;
    @RequestMapping("/insertTbUser")
    public String insertTbuser(TbUser tbUser){
        System.out.println("打印tbUser:"+tbUser);
        tbUser.setChName("hhh");
        this.tbUserdao.insert(tbUser);
        return tbUser.toString();
    }

    @GetMapping("/aaa/findProductById/{pid}")
    public Goods findProductById1(@PathVariable("pid") Integer pid){
        Goods goods = new Goods(1001,"洗衣机",2005.26);

        return goods;
    }

    @GetMapping("/app1/login")
    public String myLogin(){
        System.out.println("进入登录");
        return "成功进入登录";
    }


    @GetMapping("/ProductLogin.do")
    public String Login(@RequestParam("userName")String name, @RequestParam("pwd")String pwd
            ,ServerHttpRequest request) {
        String message = "";

        log.info("用户名：[{}]",name);
        log.info("密码：[{}]",pwd);
        if("admin".equals(name)||"123".equals(pwd)){
           message = "登陆成功";
            Map<String, String> payload = new HashMap<>();
            payload.put("userName",name);
            payload.put("pwd",pwd);
        }else {
            message = "登录失败";
        }
        return message;
    }


}
