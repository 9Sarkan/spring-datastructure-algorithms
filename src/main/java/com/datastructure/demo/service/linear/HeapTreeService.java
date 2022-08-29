package com.datastructure.demo.service.linear;

import java.util.ArrayList;
import java.util.Arrays;

import org.yaml.snakeyaml.util.ArrayUtils;

public class HeapTreeService {
    ArrayList<Integer> tree = new ArrayList<>();

    public void Insert(int data){
        tree.add(data);

        // if its the first item of tree just return
        if (tree.size() == 0 )
            return;
        
        // else we need to heapify tree
        for(int i =  2 * tree.size() - 1; i >= 0; i--)
            Heapify(tree, i);
    }

    public void Delete(int data) {
        int index = Search(data);
        if (index == -1)
            return;

        // swap found index with last item of the tree
        int temp = tree.get(index);
        tree.set(index, tree.get(tree.size()-1));
        tree.set(tree.size()-1, temp);

        // delete the last item of the tree
        tree.remove(tree.size() - 1);

        // heapify the tree
        for(int i= 2 * tree.size() / 2 - 1; i >= 0; i--)
            Heapify(tree, i);
    }

    /**
     * Search and return index of data if not exists return -1;
     * @return 
     *  */ 
    public int Search(int data){
        for(int i=0;i<tree.size();i++){
            if (tree.get(i) == data){
                return i;
            }
        }
        return -1;
    }

    /**
     * get maximum number of the tree.
     * @return
     * @throws Exception
     */
    public int Maximum() throws Exception {
        if (tree.isEmpty())
            throw new Exception("tree is empty!");
        return tree.get(0);
    }

    public void Heapify(ArrayList<Integer> tree, int i){
        int size = tree.size();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && tree.get(left) > tree.get(largest))
            largest = left;

        if (right < size && tree.get(right) > tree.get(largest))
            largest = right;

        if (largest != i){
            int temp = tree.get(largest);
            tree.set(largest, tree.get(i));
            tree.set(i, temp);

            Heapify(tree, largest);
        }
    }

    public void PrintTree() {
        for (int i = 0; i < tree.size(); i++)
            System.out.print(tree.get(i) + ", ");
    }
}
