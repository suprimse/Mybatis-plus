package com.bjpowernode.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjpowernode.vo.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
}