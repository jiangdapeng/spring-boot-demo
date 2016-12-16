package com.netease.ux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JDP on 2016/12/16.
 */

@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("/userCnt")
    public Integer userCnt(){
       return userService.getUserCnt();
    }
}
