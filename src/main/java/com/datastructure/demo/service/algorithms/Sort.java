package com.datastructure.demo.service.algorithms;


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

    public int[] mergeSort(int[] array){
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right){
        if (left < right){
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle+1, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right){
        // calculate len of both sub-arraies and create them
        int lenLeft = middle - left + 1;
        int lenRight = right - middle;

        int[] leftSide = new int[lenLeft];
        int[] rightSide = new int[lenRight];

        // fill both arraies
        for (int i = 0; i < lenLeft; i++){
            leftSide[i] = array[left + i];
        }
        for (int j = 0; j < lenRight; j++){
            rightSide[j] = array[middle + j + 1];
        }

        // iterate to merge both arraies
        int i, j, k;
        i = j = 0;
        k = left;
        while(i < lenLeft && j < lenRight){
            if (leftSide[i] < rightSide[j]){
                array[k] = leftSide[i];
                i++;
            } else {
                array[k] = rightSide[j];
                j++;
            }
            k++;
        }

        // check which sub array still not finished and move its items to main array
        while (i < lenLeft) {
            array[k] = leftSide[i];
            i++;
            k++;
        }
        while (j < lenRight){
            array[k] = rightSide[j];
            j++;
            k++;
        }
    }
}
