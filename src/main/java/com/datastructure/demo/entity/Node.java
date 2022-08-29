package com.datastructure.demo.entity;

public class Node {
    int data;
    Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public int GetData() {
        return data;
    }

    public Node GetNext() {
        return next;
    }

    public void SetData(int data){
        this.data = data;
    }

    public void SetNext(Node next){
        this.next =  next;
    }
}
