package com.automation.testing.controller;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/")
@ResponseBody
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "Hello  Docker World !!";
    }


    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestParam(name = "userName")String userName){
        return "你好 我是"+userName;
    }
}