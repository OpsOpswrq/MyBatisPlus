package com.feng;

import com.feng.mapper.UserMapper;
import com.feng.pojo.User;
import com.feng.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        for (User user : userMapper.selectList(null)) {
            System.out.println(user);
        }
    }
    @Test
    void testInsert(){
        User user = new User("feng",18,"hangzhou");
        userMapper.insert(user);
        System.out.println(user.getUid());
    }
    @Test
    void testDeleteById(){
//        userMapper.deleteById(11);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name","feng");
//        userMapper.deleteByMap(map);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(66);
        integers.add(67);
        integers.add(68);
        userMapper.deleteBatchIds(integers);
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setUid(1);
        user.setUserName("feng");
        userMapper.updateById(user);
    }
    @Test
    void testSelect(){
        User user = userMapper.selectById(1);
        System.out.println(user);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(66);
        integers.add(67);
        integers.add(68);
        List<User> users = userMapper.selectBatchIds(integers);
        for (User user1 : users) {
            System.out.println(user1);
        }
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("id",1);
//        map.put("name","feng");
//        List<User> users1 = userMapper.selectByMap(map);
//        for (User user2 : users1) {
//            System.out.println(user2);
//        }
    }
    @Test
    void testMan(){
        Map<String, Object> stringObjectMap = userMapper.selectByMap(1);
        System.out.println(stringObjectMap);
    }
    @Test
    void testService(){
        System.out.println(userService.count());
    }
    @Test
    void testInsertBatch(){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1;i<=10;i++){
            User user = new User();
            user.setUserName("feng"+i);
            user.setAge(18+i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);
    }
}
