package com.datastructure.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.demo.service.linear.StackService;


@RestController
@RequestMapping(path="/stack/")
public class StackController {

    public static StackService stack = new StackService(10);

    @GetMapping(path="/pop")
    public Integer Pop() {
        return 0;
    }

    @GetMapping(value="/push/{value}")
    public Integer Push(@PathVariable("value") Integer value) {
        return value;
    }

    @GetMapping(value="/peek")
    public Integer Peek() {
        return 0;
    }
    
}
