package com.datastructure.demo.service.linear;

public class Tree {
    Node root;
  
    // Tree Node
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
  
    // Function to insert nodes in level order
    public Node insertLevelOrder(Integer[] arr, int i)
    {
        Node root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new Node(arr[i]);
  
            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);
  
            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }
  
    // Function to print tree nodes in InOrder fashion
    public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
}