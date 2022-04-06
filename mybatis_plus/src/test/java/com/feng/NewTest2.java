package com.feng;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.enums.SexEnum;
import com.feng.mapper.ProductMapper;
import com.feng.mapper.UserMapper;
import com.feng.pojo.Product;
import com.feng.pojo.User;
import com.feng.service.ProductService;
import com.feng.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NewTest2 {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductService productService;
    @Test
    void testPage(){
        Page<User> userPage = new Page<>(2,3);
        userMapper.selectPage(userPage,null);
        for (User record : userPage.getRecords()) {
            System.out.println(record);
        }
        System.out.println("当前页为"+userPage.getCurrent());
        System.out.println("每页显示的条数"+userPage.getSize());
        System.out.println("总记录数"+userPage.getTotal());
        System.out.println("总页数"+userPage.getPages());
        System.out.println("是否有上一页"+userPage.hasNext());
        System.out.println("是否有下一页"+userPage.hasPrevious());
    }
    @Test
    void testManualPage(){
        Page<User> userPage = new Page<>(2,3);
        userMapper.selectPageTest(userPage,10);
        List<User> records = userPage.getRecords();
        for (User record : records) {
            System.out.println(record);
        }
    }
    @Test
    void testProduct(){
        Product product1 = productMapper.selectById(1);
        Product product2 = productMapper.selectById(1);
        System.out.println(product1);
        System.out.println(product2);
        product1.setPrice(product1.getPrice()+50);
        productMapper.updateById(product1);
        product2.setPrice(product2.getPrice()-30);
        int i = productMapper.updateById(product2);
        if(i==0){
            product2 = productMapper.selectById(1);
            product2.setPrice(product2.getPrice()-30);
            productMapper.updateById(product2);
        }
        Product product = productMapper.selectById(1);
        System.out.println(product);
    }
    @Test
    void testEnum(){
        User user = new User();
        user.setEmail("test");
        user.setAge(30);
        user.setUserName("feng");
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);
    }
    @Test
    void test01(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}
