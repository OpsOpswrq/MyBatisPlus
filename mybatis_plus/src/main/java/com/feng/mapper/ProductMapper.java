package com.feng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
