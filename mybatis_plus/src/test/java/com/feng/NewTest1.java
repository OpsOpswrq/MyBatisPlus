package com.feng;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.mapper.UserMapper;
import com.feng.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.SeparatorUI;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class NewTest1 {
    @Autowired
    UserMapper userMapper;
    @Test
    void testQueryWrapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","a")
//                .between("age",20,30)
                .ge("age",20)
                .le("age",30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void test01(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void test02(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNull("email");
        int delete = userMapper.delete(userQueryWrapper);
        System.out.println(delete);
    }
    @Test
    void test03(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name",'a')
                .gt("age",20)
                .or()
                .isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("test");
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println(update);
    }
    @Test
    void test04(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","a")
                .and(i->i.gt("age",20).or().isNull("email")); // lambda表达式
        User user = new User();
        user.setAge(18);
        user.setEmail("test");
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println(update);
    }
    @Test
    void test05(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("name","age");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    @Test
    void test06(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("id","select id from user where id<=3");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void test07(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("age",18)
                .set("email","user@localhost")
                .like("name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        int update = userMapper.update(null, userUpdateWrapper);
        System.out.println(update);
    }
    @Test
    void test08(){
        String username = null;
        int ageBegin = 10;
        int ageEnd = 20;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like(StringUtils.isNotBlank(username),"name",'a')
                .ge(String.valueOf(ageBegin) != null,"age",ageBegin)
                .le(String.valueOf(ageEnd) != null,"age",ageEnd);
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void test09(){
        LambdaQueryWrapper<User> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = "a";
        int ageBegin = 10;
        int ageEnd = 20;
        objectLambdaQueryWrapper.like(StringUtils.isNotBlank(name),User::getUserName,name)
                .ge(String.valueOf(ageBegin)!=null,User::getAge,ageBegin)
                .le(String.valueOf(ageEnd)!=null,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(objectLambdaQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    void test10() {
        LambdaUpdateWrapper<User> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper.set(User::getAge, 18)
                .set(User::getEmail, "feng")
                .like(User::getUserName, 'a')
                .and(i -> i.lt(User::getAge, 24).or().isNull(User::getEmail));
        User user1 = new User();
        userMapper.update(user1, userLambdaUpdateWrapper);
    }
}
