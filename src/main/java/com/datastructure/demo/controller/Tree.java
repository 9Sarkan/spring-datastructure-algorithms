package com.datastructure.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.demo.service.tree.BinarySearchTree;
import com.datastructure.demo.service.tree.Node;
import com.datastructure.demo.service.tree.TreeTraversal;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping(path="/tree/")
public class Tree {

    @GetMapping(path = "/test")
    @ResponseStatus(code = HttpStatus.OK)
    public JSONObject testTree() {
        
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

    @GetMapping(path="/bst/test")
    @ResponseStatus(code=HttpStatus.OK)
    public JSONObject testBSTree(){
        // create a tree
        BinarySearchTree tree = new BinarySearchTree(30);
        
        // insert some data
        tree.insert(20);
        tree.insert(24);
        tree.insert(23);
        tree.insert(22);
        tree.insert(40);
        tree.insert(32);
        tree.insert(30);
        tree.insert(20);
        tree.insert(22);
        tree.insert(45);
        tree.insert(48);
        tree.delete(22);
        tree.delete(22);
        tree.delete(40);

        // convert to json object
        JSONObject obj = new JSONObject();
        obj.put("inOrder", tree.inOrder());
        obj.put("preOrder", tree.preOrder());
        obj.put("postOrder", tree.postOrder());

        JSONObject searchObj = new JSONObject();
        searchObj.put("key", 22);
        Node searchedNode = tree.search(22);
        searchObj.put("result", searchedNode != null);


        obj.put("search", searchObj);

        return obj;
    }
}
