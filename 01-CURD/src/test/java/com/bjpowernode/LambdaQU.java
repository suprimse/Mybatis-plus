package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.bjpowernode.vo.User;
import org.junit.jupiter.api.Test;

/**
 * @Author: 张艺腾
 * @Date: 2022/04/16/11:17
 * @Description:
 */
public class LambdaQU {
    User user =new User();
    @Test
    public void Lambda01() {
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(()
    }
}
