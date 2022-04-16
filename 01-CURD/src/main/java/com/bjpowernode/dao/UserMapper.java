package com.bjpowernode.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjpowernode.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * ServiceImpl实现了IService，提供了IService中基础功能的实现
 * 若ServiceImpl无法满足业务需求，则可以使用自定的UserService定义方法，并在实现类中实现
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id来查询用户信息为map集合
     * @param id Mybatis-Plus所提供的分页对象，必须放在第一个参数的位置
     * @return
     */
    Map<String,Object> selectId(Long id);

    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);

}