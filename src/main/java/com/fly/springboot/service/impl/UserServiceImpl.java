package com.fly.springboot.service.impl;

import com.fly.springboot.entity.User;
import com.fly.springboot.repository.UserRepository;
import com.fly.springboot.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author fly
 * @date 2018/5/13 21:36
 * @description     用户服务接口的实现类
 **/
@Service
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.fly.springboot.repository")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
       return userRepository.getOne(id);
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        return userRepository.findByNameLike("%" + name + "%", pageable);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
