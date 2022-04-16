package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.bjpowernode.dao.UserMapper;
import com.bjpowernode.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: 张艺腾
 * @Date: 2022/04/16/11:17
 * @Description:
 */
public class LambdaQU {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void Lambda01() {
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin!=null,User::getAge,ageBegin)
                .le(ageEnd!=null,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
    }
    public void Lambda02() {
        //组装set
        LambdaUpdateWrapper<User> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(User::getAge,18)
                            .and(i->i.lt(User::getAge,24).or().isNull(User::getEmail));
        User user=new User();
        int update = userMapper.update(user, lambdaUpdateWrapper);
        System.out.println(update);
        System.out.println("github");
    }

}
