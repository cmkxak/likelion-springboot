package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .body(userDao.findById(id));
    }

    @PostMapping("/user")
    public void save(@RequestBody User user) {
        userDao.add(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .body(userDao.delete(id));
    }

    @DeleteMapping("/user/all")
    public ResponseEntity<Integer> deleteUserAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
