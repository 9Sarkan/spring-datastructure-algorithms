package com.datastructure.demo.service.linear;

import com.datastructure.demo.entity.Node;

public class LinkedListService {
    Node head;

    public LinkedListService(int data){
        head = new Node(data, null);
    }

    public void InsertAfter(Node prevNode, int data) throws Exception {
        if (prevNode == null){
            throw new Exception("previous must not be null");
        }
        prevNode.SetNext(new Node(data, prevNode.GetNext()));
    }

    public void Insert(int data){
        if (head == null){
            head = new Node(data, null);
            return;
        }
        Node lastNode = head;
        while (lastNode.GetNext() != null){
            lastNode = lastNode.GetNext();
        }

        lastNode.SetNext(new Node(data, null));
    }

    public void Traverse(){
        Node temp = head;
        while (temp.GetNext() != null){
            System.out.println(temp.GetData());
            temp = temp.GetNext();
        }
    }
}
