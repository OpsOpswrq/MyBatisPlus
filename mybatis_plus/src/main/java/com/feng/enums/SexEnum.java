package com.feng.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");
    private int sex;
    @EnumValue
    private String sexName;
    SexEnum(int sex,String sexName){
        this.sex = sex;
        this.sexName = sexName;
    }
}
