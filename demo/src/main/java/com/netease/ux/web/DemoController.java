package com.netease.ux.web;

import com.netease.ux.domain.User;
import com.netease.ux.domain.UserDao;
import com.netease.ux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JDP on 2016/12/16.
 */

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("/userCnt")
    public Long userCnt(){
        return userDao.count();
    }

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }


    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public Long newUser(@ModelAttribute User user) {
        user = userDao.save(user);
        return user.getId();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userDao.findOne(id);
    }

}
