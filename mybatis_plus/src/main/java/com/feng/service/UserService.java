package com.feng.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.pojo.User;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public interface UserService extends IService<User> {
}
