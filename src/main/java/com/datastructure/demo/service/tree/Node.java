package com.datastructure.demo.service.tree;

public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int GetData(){return this.data;}
    public void SetData(int data) {this.data = data;}
    public Node GetLeft() {return this.left;}
    public Node GetRight() {return this.right;}
    public void SetLeft(Node left){this.left = left;}
    public void SetRight(Node right){this.right=right;}
}
