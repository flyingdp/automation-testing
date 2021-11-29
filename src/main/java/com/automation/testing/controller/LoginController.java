package com.automation.testing.controller;

import com.automation.testing.request.LoginRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestBody LoginRequest request){
        if (!"root".equals(request.getName())){
            return "Name Fail";
        }
        if (!"123456".equals(request.getPwd())){
            return "Pwd Fail";
        }
        if (!"1234".equals(request.getCode())){
            return "Code Fail";
        }
        System.out.print("登录成功");
        return "Login Success";
    }

    @RequestMapping("/logout")
    public String logout(@RequestBody LoginRequest request){
        return "Logout Success";
    }
}
