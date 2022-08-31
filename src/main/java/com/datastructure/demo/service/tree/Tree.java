package com.datastructure.demo.service.tree;

public class Tree {
    private int size;
    private Node root;

    public Tree(int data){
        this.root = new Node(data, null, null);
        size+=1;
    }

    public int size() {
        return this.size;
    }

    public Node root(){
        return this.root;
    }

    public void setRoot(Node root){
        this.root = root;
    }
}
