package com.newer.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.newer.dao.EmpDao;
import com.newer.data.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableBinding(Source.class)
@RestController
public class MyProvider {
    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel channel;

    @GetMapping("send")
    public void send() {
        System.out.println("发起Send请求");
        channel.send(MessageBuilder.withPayload("Hello World!").build());
    }

    @Autowired
    EmpDao empDao;
    @GetMapping("/findDeptById/{Deptid}")
    public void findDeptById(@PathVariable("Deptid") Integer Deptid){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("DEPTNO",Deptid);
        System.out.println("findDeptById打印："+empDao.selectList(wrapper));
        channel.send(MessageBuilder.withPayload(empDao.selectList(wrapper)).build());
    }
}