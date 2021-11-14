package com.automation.testing.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
@ResponseBody
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "Hello  Docker World !!";
    }
}