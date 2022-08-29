package com.datastructure.demo.service.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeTraversal extends Tree {
    public TreeTraversal(int data) {
        super(data);
    }

    public Integer[] inOrder() {
        return Arrays.asList(this.inOrder(this.root()).toArray()).toArray(new Integer[0]);
    }

    public Integer[] preOrder(){
        return Arrays.asList(this.preorder(this.root()).toArray()).toArray(new Integer[0]);
    }

    public Integer[] postOrder(){
        return Arrays.asList(this.postOrder(this.root()).toArray()).toArray(new Integer[0]);
    }

    private ArrayList<Integer> inOrder(Node root){
        if (root == null)
            return null;
        
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> leftArr = inOrder(root.left);
        ArrayList<Integer> rightArr = inOrder(root.right);

        if (leftArr != null ){
            arr.addAll(leftArr);
        }
        
        arr.add(root.GetData());
        
        if (rightArr != null){
            arr.addAll(rightArr);
        }

        return arr;
    }

    private ArrayList<Integer> preorder(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> leftSide = preorder(root.left);
        ArrayList<Integer> rightSide = preorder(root.right);

        arr.add(root.GetData());

        if (leftSide != null){
            arr.addAll(leftSide);
        }

        if (rightSide != null){
            arr.addAll(rightSide);
        }

        return arr;
    }

    private ArrayList<Integer> postOrder(Node root) {
        if (root == null){
            return null;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> leftSide = postOrder(root.left);
        ArrayList<Integer> rightSide = postOrder(root.right);

        if (leftSide != null){
            arr.addAll(leftSide);
        }

        if (rightSide != null) {
            arr.addAll(rightSide);
        }

        arr.add(root.GetData());

        return arr;
    }
}
