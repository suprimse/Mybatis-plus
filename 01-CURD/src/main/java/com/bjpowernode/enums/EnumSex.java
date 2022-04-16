package com.bjpowernode.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum EnumSex {
    MALE(1, "男"),
    FEMALE(2, "女");
    @EnumValue
    private Integer sex;
    private String sexName;

    EnumSex(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;

    }
}
