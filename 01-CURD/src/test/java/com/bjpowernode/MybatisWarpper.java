package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.dao.UserMapper;
import com.bjpowernode.vo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisWarpper {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE
        //is_deleted=0 AND (username LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03() {
        //删除email为空的用户
        //DELETE FROM t_user WHERE (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        //条件构造器也可以构建删除语句的条件
        int result = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE (username LIKE ? AND age > ? ORemail IS NULL)
        queryWrapper
                .like("username", "a")
                .gt("age", 20)
                .or()
                .isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testLambad04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE (username LIKE ? AND (age > ? ORemail IS NULL))
        //lambda表达式内的逻辑优先运算
        queryWrapper.like("username", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test05() {
        //查询用户信息的username和age字段
        //SELECT username,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("username", "age");
        //selectMaps()返回Map集合列表，通常配合select()使用，避免User对象中没有被查询到的列值为null
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test06() {
        //查询id小于等于3的用户信息
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE (id IN(select id from t_user where id <= 3))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from t_user where id <= 3");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
    //业务逻辑
    @Test
    public void test08() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("username","a");
        }
        if(ageBegin != null){
            queryWrapper.ge("age", ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age", ageEnd);
        }
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE (age >=? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    //简化版
    @Test
    public void test08UseCondition() {
    //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    //StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
                queryWrapper.like(StringUtils.isNotBlank(username), "username", "a")
                        .ge(ageBegin != null, "age", ageBegin)
                        .le(ageEnd != null, "age", ageEnd);
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE (age >=? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }



}
