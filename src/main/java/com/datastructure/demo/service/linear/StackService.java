package com.datastructure.demo.service.linear;

import org.springframework.data.rest.webmvc.support.ExceptionMessage;

public class StackService {
    Integer[] stack; 
    int currentItemLength;
    int size;

    public StackService(int size){
        this.size = size;
        currentItemLength = 0;
        stack = new Integer[size];
    }

    /**
     * @param item
     * @throws Exception
     */
    public void Push(Integer item) throws Exception {
        if (currentItemLength > size) {
            throw new Exception("Stack if full!");
        }
        stack[currentItemLength] = item;
        currentItemLength += 1;
    }

    public Integer Pop(){
        return 0;
    }

    public Integer Peek() {
        return 0;
    }
}
