package com.newer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //第二种：利用注解动态读取配置中心的配置项。
public class MyConfigControl {


    //第一种：使用接口实现配置中心配置项的动态读取。
    //Nacos配置中文动态读取配置项。
//    @Autowired
//    private ConfigurableApplicationContext applicationContext;

    /*
     * 使用bean对象是单例的
     * 使用java反射技术创建MyConfigControl，beanid=MyConfigControl
     * 1.初始化时使用无参构造
     * 2.给MyConfigControl中的对象成员属性赋值，my.address=http://www.baidu.com
     * @Value读取本地配置文件
     * */
    @Value("${my.address}")
    private String address;

    @Value("${config.env}")
    private String myenv;


    @RequestMapping("/getConfig")
    public String getConfig() {
        System.out.println("动态打印从bootstrap.properties读取的配置：" + address);
        System.out.println("从nacos读取的不同环境动态配置："+myenv);
        return myenv;
        //return address;

        //my.address=http://www.newer.com
        //Enviroment.getProperty(配置项的键)
//        String res = applicationContext.getEnvironment().getProperty("my.address");
//        return "动态读取配置："+res;
    }
}
