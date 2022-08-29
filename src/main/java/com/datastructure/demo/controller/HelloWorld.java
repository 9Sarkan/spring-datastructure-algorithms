package com.datastructure.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/hello/")
public class HelloWorld {

    @GetMapping(path="/")
    public String SayHello(){
        return "hello world Test tomcat";
    }
}
