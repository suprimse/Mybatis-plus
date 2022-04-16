package com.bjpowernode;

import com.bjpowernode.dao.UserMapper;
import com.bjpowernode.enums.EnumSex;
import com.bjpowernode.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisEnum {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSexEnum(){
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(EnumSex.MALE);
        //INSERT INTO t_user ( username, age, sex ) VALUES ( ?, ?, ? )
        //Parameters: Enum(String), 20(Integer), 1(Integer)
        userMapper.insert(user);
    }
}
