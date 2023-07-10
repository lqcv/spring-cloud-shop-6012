package com.newer.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//调用服务提供者openfeign
@RestController
public class FeignControl {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    //http://localhost:8072/helloGoods1/8
    @RequestMapping(value = "/helloGoods1/{pid}",method = RequestMethod.GET)
    public String helloGoods1(@PathVariable("pid") Integer pid) {
        StringBuilder sb = new StringBuilder();

        // 产品服务的ip和端口
        String memberUrl = "http://product-service" + "/findProductById/" + pid;
        System.out.println("URL：" + memberUrl);

        String res1 = restTemplate.getForObject
                ("http://product-service/findProductById/" + pid, String.class);
        System.out.println("服务提供者openfeign：" + res1);
        sb.append("服务提供者openfeign：" + res1);
        return sb.toString();
    }
}
