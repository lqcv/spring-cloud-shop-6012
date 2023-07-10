package com.newer.control;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.newer.dao.EmpDao;
import com.newer.data.entity.Emp;
import com.newer.data.entity.Goods;
import com.newer.sercive.SentinelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class ProductSentinelControl {
    private static final Logger logger = LoggerFactory.getLogger(ProductSentinelControl.class);

//    @GetMapping("/findProductById/{pid}")
//    public Goods findProductById(@PathVariable("pid") Integer pid){
////        Goods goods = new Goods(1001,"洗衣机",2005.26);
////        return goods;
//        Goods goods = new Goods(1001,"洗衣机",2005.26);
////        try {
////            TimeUnit.MILLISECONDS.sleep(5000);//延时5秒
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        return goods;
//    }

    //处理流控、熔断和热点规则异常。
    public String blockHandler(Integer id, BlockException e){
        if(e instanceof FlowException){//流控
            return  "当前请求被流控！";
        }
        if(e instanceof DegradeException){//熔断
            return  "当前请求被降级！";
        }
        if(e instanceof ParamFlowException){//热点
            return  "当前请求被热点参数限流!";
        }
        return "当前访问人数太多，请稍后再试！";
    }

    /**
     * @SentinelResource: 代表这是一个sentinel资源
     * value: 资源名称
     * blockHandler: 使用sentinel进行不同规则控制时的默认处理方案
     * fallback: 自定义业务出错时默认处理方案
     * defaultFallback: 业务错误时的默认处理方案
     */
    @RequestMapping("/hello")
    @SentinelResource(value = "hello",blockHandler = "blockHandler")
    public String sayHello(Integer id){
        logger.info("Hello, Sentinel!");
        if(id < 0){
            System.out.println("抛出RuntimeException");
            throw new RuntimeException();
        }
        return "Hello, Sentinel!";
    }




    @Autowired
    EmpDao empDao;
    @GetMapping("/findDeptById/{Deptid}")
    public List<Emp> findDeptById(@PathVariable("Deptid") Integer Deptid){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("DEPTNO",Deptid);
        System.out.println("findDeptById打印："+empDao.selectList(wrapper));
//        try {
////            TimeUnit.MILLISECONDS.sleep(1000);//延时5秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return empDao.selectList(wrapper);
    }


    /**
     * Sentinel提供流控的关联机制：
     * 根据业务规则，两个方法处在前后调用过程，
     * 如果大量的请求可能冲垮第一个服务方法，
     * 之后运行的方法应该通过Sentinel暂时禁用。
     * 等待第一个方法经过大流量后恢复再启动第二个微服务方法。
     * sentinel()就是一个可能被大量用户请求冲垮的微服务方法。-》注册
     * @return
     */
    @GetMapping("/sentinel")
    public String sentinel() {
        return "hello, sentinel dashboard....";
    }


    //加入业务层方法：@SentinelResource("sentinelChain")
    @Autowired
    private SentinelService sentinelService;

    //拼接URL路径：sentinelChain/testA
    @GetMapping("/testA")
    public String testA() {
        logger.info("SentinelController>>>>>testA() execute....");
        return sentinelService.sentinelChain();
    }

    @GetMapping("/testB")
    public String testB() {
        logger.info("SentinelController>>>>>testB() execute....");
        return sentinelService.sentinelChain();
    }


    //findProductById()方法是根据业务规则是在
    //sentinel方法之后必须执行。->登录
    @GetMapping("/findProductById/{pid}")
    public Goods findProductById(@PathVariable("pid") Integer pid){
//        Goods goods = new Goods(1001,"洗衣机",2005.26);
//        return goods;
        Goods goods = new Goods(1001,"洗衣机",2005.26);
        if(pid < 0){
            throw new RuntimeException();
        }

        //        try {
//            TimeUnit.MILLISECONDS.sleep(5000);//延时5秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return goods;
    }


    /**
     * @SentinelResource进行异常处理
     * @SentinelResource: 代表这是一个sentinel资源
     * value: 资源名称
     * blockHandler: 使用sentinel进行不同规则控制时的默认处理方案
     * fallback: 自定义业务出错时默认处理方案
     * defaultFallback: 业务错误时的默认处理方案
     */
//    @RequestMapping("/hello")
//    @SentinelResource(value = "hello",defaultFallback = "defaultFallback")
//    public String sayHello(Integer id){
//        logger.info("Hello, Sentinel!");
//        if(id < 0){
//            System.out.println("抛出RuntimeException");
//            throw new RuntimeException();
//        }
//        return "Hello, Sentinel!";
//    }
//
//    public String defaultFallback(){
//        return "默认的fallback函数处理的异常！";
//    }


    /**
     * @SentinelResource: 代表这是一个sentinel资源
     * value: 资源名称
     * blockHandler: 使用sentinel进行不同规则控制时的默认处理方案
     * fallback: 自定义业务出错时默认处理方案（指定异常）
     * defaultFallback: 业务错误时的默认处理方案（所有异常）
     */
//    @RequestMapping("/hello")
//    @SentinelResource(value = "hello",fallback = "fallback")
//    public String sayHello(Integer id){
//        logger.info("Hello, Sentinel!");
//        if(id < 0){
//            System.out.println("抛出RuntimeException");
//            throw new RuntimeException();
//        }
//        return "Hello, Sentinel!";
//    }
//
//    public String fallback(Integer id){
//        return "fallback函数处理的异常!";
//    }

}
