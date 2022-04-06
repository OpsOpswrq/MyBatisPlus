package com.feng.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class Product {
    private int id;
    @TableField("NAME")
    private String name;
    private int price;
    @TableField("VERSION")
    @Version
    private int version;
}
