package com.datastructure.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.demo.service.tree.Node;
import com.datastructure.demo.service.tree.TreeTraversal;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping(path="/tree/")
public class Tree {

    @GetMapping(path = "/test")
    @ResponseStatus(code = HttpStatus.OK)
    public JSONObject TestTree() {
        
        // create a tree
        TreeTraversal tree = new TreeTraversal(100);
        Node leftSide = new Node(50, new Node(30, new Node(10, null, null), null), new Node(20, null, null));
        Node rightSide = new Node(40, new Node(41, new Node(43, null, null), null), new Node(42, null, null));
        tree.root().SetLeft(leftSide);
        tree.root().SetRight(rightSide);
        
        
        // convert to json object
        JSONObject obj = new JSONObject();
        obj.put("inOrder", tree.inOrder());
        obj.put("preOrder", tree.preOrder());
        obj.put("postOrder", tree.postOrder());

        return obj;
    } 
}
