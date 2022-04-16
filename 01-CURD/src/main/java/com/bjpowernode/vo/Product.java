package com.bjpowernode.vo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Product {
private Long id;
private String name;
private Integer price;
//乐观锁版本号字段
@Version
private Integer version;
}