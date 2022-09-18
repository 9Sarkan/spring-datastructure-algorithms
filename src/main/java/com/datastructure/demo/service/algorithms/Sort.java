package com.datastructure.demo.service.algorithms;

import com.jayway.jsonpath.internal.function.text.Length;

public class Sort {

    public int[] bubbleSort(int[] array){
        boolean swap = false;
        for(int i=0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j+1]){
                    // swap
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                return array;
            }
        }
        return array;
    }

    public int[] selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int minimum = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[minimum] > array[j]){
                    minimum = j;
                }
            }
            // swap
            int temp = array[minimum];
            array[minimum] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < i; j++){
                if (array[j] > array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
