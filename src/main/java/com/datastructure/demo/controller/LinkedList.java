package com.datastructure.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.demo.repository.DataStorage;
import com.datastructure.demo.service.linear.LinkedListService;

@RestController
@RequestMapping(path = "/linked-list/")
public class LinkedList {
    @GetMapping(path = "/insert/{username}/{data}")
    public int Insert(@PathVariable("username") String username, @PathVariable("data") int data){
        LinkedListService userLinkedList = DataStorage.dataMap.get(username);
        if (userLinkedList == null) {
            userLinkedList = new LinkedListService(data);
            DataStorage.dataMap.put(username, userLinkedList);
            return data;
        }
        userLinkedList.Insert(data);
        return data;
    }

    @GetMapping(path="/print/{username}")
    public String PrintLinkedList(@PathVariable("username") String username){
        LinkedListService userLinkedList = DataStorage.dataMap.get(username);
        if (userLinkedList == null) {
            return String.format("Username %s not found!", username);
        }
        userLinkedList.Traverse();
        return String.format("%s linked list printed!", username);
    }
}
