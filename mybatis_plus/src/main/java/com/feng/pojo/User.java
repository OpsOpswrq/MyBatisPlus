package com.feng.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.feng.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("User")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private int Uid;
    @TableField("name")
    private String UserName;
    private int age;
    private String email;
    @TableLogic
    private int is_deleted = 0;
    private SexEnum sex;
    public User(String name,int age,String email){
        this.age = age;
        this.email = email;
        this.UserName = name;
    }
}
