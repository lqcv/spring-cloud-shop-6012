package com.newer.controll;

import com.newer.data.entity.Goods;
import com.newer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class ProductFeignControl {
//    //调用open-feign接口-》 @FeignClient
//    @Autowired
//    ProductService productService;//绑定Feign Service
//
//    @GetMapping("/order/{pid}")
//    public String order(@PathVariable("pid")Integer pid){
//        //启动业务层
//        //ProductService->Open-Feign接口
//        //调用接口findProductById实现指向服务提供者微服务方法的URL路径生成。
//        //等同于调用服务提供的findProductByid的方法
//        Goods good = this.productService.findProductById(pid);
//        System.out.println("自openFeign返回Goods："+good);
//        return "开始下订单openfeign::::"+good.toString();
//    }
//
//    //http://localhost:8072/helloGoods
//    @RequestMapping(value = "/helloGoods",method = RequestMethod.GET)
//    public String helloGoods(){
//        StringBuilder sb=new StringBuilder();
////        String res1 = this.productService.hello("牛耳教育");
////        sb.append(res1);
//
////        Goods goods = this.productService.hello(1,"电视机",2560.86);
////        sb.append("绑定参数转换Goods："+goods.toString());
//
//        String res2 =  this.productService.hello(new Goods(1,"电视机",2560.26));
//        sb.append("绑定参数转换字符串："+res2);
//
//        return sb.toString();
//    }
}
