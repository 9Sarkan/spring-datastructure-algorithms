package com.datastructure.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.datastructure.demo.repository.DataStorage;
import com.datastructure.demo.service.linear.HeapTreeService;


@RestController
@RequestMapping(path="/heap/")
public class HeapTree {

    @GetMapping(path = "/insert/{username}/{data}")
    public int Insert(@PathVariable("username") String username, @PathVariable("data") int data){
        HeapTreeService userHeap = DataStorage.HeapTree.get(username);
        if(userHeap == null){
            userHeap = new HeapTreeService();
            userHeap.Insert(data);
            DataStorage.HeapTree.put(username, userHeap);
            return data;
        }
        userHeap.Insert(data);
        return data;   
    }

    @GetMapping(path="/delete/{username}/{data}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "resource deleted successfully")
    public String Delete(@PathVariable("username") String username, @PathVariable("data") int data) {
        HeapTreeService userHeap = DataStorage.HeapTree.get(username);
        if(userHeap == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user %s not found!", username));
        }
        userHeap.Delete(data);
        return "item deleted";
    }
    

    @GetMapping(path="/print/{username}")
    public String Print(@PathVariable("username") String username){
        HeapTreeService userHeap = DataStorage.HeapTree.get(username);
        if(userHeap == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("user %s not found!", username));
        }
        userHeap.PrintTree();
        return "tree printed in console";
    }

}
