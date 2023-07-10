package com.newer.control;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserControl {

    @GetMapping("/usersInsert")
    public String InsertUSer(){
        System.out.println("用户注册方法");
        return "用户注册";
    }

    @GetMapping("/usersLogin")
    public String LoginUSer(){
        System.out.println("用户登录方法");
        return "用户登录";
    }


    @GetMapping("/Login.do")
//    @SentinelResource(value = "Login.do",defaultFallback = "defaultFallback")
    @SentinelResource(value = "Login.do",defaultFallback = "blockHandler")
    public String Login(@RequestParam("name")String name, @RequestParam("pwd")String pwd) throws AgeException {
        if(!"admin".equals(name)||!"123".equals(pwd)){
            System.out.println("用户名或密码错误");
            throw new AgeException("用户名或密码错误");
//            throw new RuntimeException();
        }
        return "登录成功！";
    }

    public String defaultFallback(){
        return "默认的fallback函数处理的异常！";
    }

    //处理流控、熔断和热点规则异常。
    public String blockHandler(Integer id, Exception e){
        if(e instanceof AgeException){//流控
            System.out.println("抓到异常");
            return  "用户名或密码错误！";
        }
        return "用户名和密码出错。！";
    }

        @Value("${my.userName}")
        String name;
        @Value("${my.userPassword}")
        String password;

        @RequestMapping("/Userinsert.do")
        public String Userinsert(){
            return "用户名："+name+"密码:"+password;
    }
}
