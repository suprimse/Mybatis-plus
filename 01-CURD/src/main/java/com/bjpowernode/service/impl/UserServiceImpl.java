package com.bjpowernode.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjpowernode.dao.UserMapper;
import com.bjpowernode.service.UserService;
import com.bjpowernode.vo.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User>implements UserService {


}
