package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Map;

@RestController
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user")
    public void save(@RequestBody User user){
        userDao.add(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id){
        userDao.delete(id);
    }

    @DeleteMapping("/user/all")
    public void deleteUserAll(){
        userDao.deleteAll();
    }

}
