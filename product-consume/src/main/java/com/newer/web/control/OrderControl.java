package com.newer.web.control;

import com.newer.data.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//服务消费者的控制器
@RestController
public class OrderControl {

    //DiscoveryClient访问Nacos服务器查找需要的服务。
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    //服务地址-》对应application.properties->#消费者要去访问的微服务名称
    //service-url.nacos-user-service: http://product-service
    @Value("${service-url.nacos-user-service}")
    private String SERVER_URL;

    @RequestMapping("/orderToProduct/{pid}")
    public String orderToProduct(@PathVariable("pid") Integer pid){

        // 产品服务的ip和端口
        String memberUrl = "http://product-service" + "/findProductById/"+pid;
        System.out.println("URL："+memberUrl);

        return restTemplate.getForObject(SERVER_URL+"/findProductById/"+pid,String.class);

        /*
         * 根据服务名称 从注册中心 获取 产品服务的接口地址
         * 服务提供 启动多个集群
         *
         */
//        List<ServiceInstance> instances =
//                discoveryClient.getInstances("product-service");
////        ServiceInstance serviceInstance = instances.get(0);
//        System.out.println("微服务的个数（服务提供者的）："+instances.size());
//        int index = new Random().nextInt(instances.size());//加入随机数随机指定不同的服务提供者。
//        //从nacos中获取服务地址
//        ServiceInstance serviceInstance = instances.get(index);
//
////        // 产品服务的ip和端口
//        return "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
//                + "/" + "findProductById/"+pid;



        /*
         * 根据服务名称 从注册中心 获取 产品服务的接口地址
         * 服务提供 启动多个集群
         *
         */
//        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
//        ServiceInstance serviceInstance = instances.get(0);
//
//        // 产品服务的ip和端口
//        String memberUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/" + "findProductById/"+pid;
////        System.out.println("URL："+memberUrl);
//        //注意：实体类必须提供无参构造方法，否则反序列化出错！！！
//        Goods goods = restTemplate.getForObject(memberUrl,Goods.class);
//        System.out.println("Goods："+goods.toString());
//
//        return "订单服务调用产品服务返回产品:" +goods.toString();




        /*
         * 根据服务名称 从注册中心 获取 产品服务的接口地址
         * 服务提供 启动多个集群
         * discoveryClient.getInstances("微服务名字product-service");
         *
         * # 应用名称
spring.application.name=product-service
         *
         *
         */
//        List<ServiceInstance> instances =
//                discoveryClient.getInstances("product-service");
//        ServiceInstance serviceInstance = instances.get(0);
//
//        // 产品服务的ip和端口
//        return "http://" + serviceInstance.getHost() + ":" +
//                serviceInstance.getPort() + "/" + "findProductById/"+pid;

    }


    @RequestMapping("/EmpByDeptId/{Deptid}")
    public List<Dept>  EmpByDeptions(@PathVariable("Deptid") Integer Deptid){
//        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        String memberUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/" + "findDeptById/"+Deptid;
//        List<Dept> deptList = restTemplate.getForObject(memberUrl,List.class);
//        System.out.println("deptList："+deptList);
//        return deptList;

        // 产品服务的ip和端口
        String memberUrl = "http://product-service" + "/findDeptById/"+Deptid;
        System.out.println("URL："+memberUrl);

        return restTemplate.getForObject(SERVER_URL+"/findDeptById/"+Deptid,List.class);
    }
}
