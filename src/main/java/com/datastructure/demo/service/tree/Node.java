package com.datastructure.demo.service.tree;

public class Node {
    int data;
    Node left;
    Node right;
    int count;

    public Node(int data, Node left, Node right) {
        this.count = 1;
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
    public int getCount() {return this.count;}
    public int increaseCount() {return ++this.count;}
    public int decreaseCount() {return --this.count;}
}
