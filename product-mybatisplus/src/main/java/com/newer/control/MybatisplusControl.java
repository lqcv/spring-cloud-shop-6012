package com.newer.control;

import com.newer.dao.TBuserDao;
import com.newer.data.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MybatisplusControl {
    @Autowired
    TBuserDao tBuserDao;

    @GetMapping("/getTbUserList.do")
    public String getTbUserList(){
        return this.tBuserDao.selectList(null).toString();
    }

    @RequestMapping("/insertTbuser.do")
//    public String insertTbuser(@RequestBody TbUser tbUser){
    public String insertTbuser(@RequestParam("userName") String userName,
                               @RequestParam("chName") String chName,
                               @RequestParam("password") String password){
        TbUser tbuser = new TbUser();
        tbuser.setUserName(userName);
        tbuser.setChName(chName);
        tbuser.setPassword(password);
        System.out.println("tbUser："+tbuser);
        String res="";
        if(this.tBuserDao.insert(tbuser)>0){
            res="添加成功";
            System.out.println("添加成功");
        }else{
            res="添加失败";
            System.out.println("添加失败");
        }
        return res;
    }
}
