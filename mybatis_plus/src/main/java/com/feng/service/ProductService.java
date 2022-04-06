package com.feng.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.pojo.Product;
import org.springframework.stereotype.Service;

@Service
@DS("slave_1")
public interface ProductService extends IService<Product> {
}
