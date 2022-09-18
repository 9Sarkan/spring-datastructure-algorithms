package com.datastructure.demo.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructure.demo.service.algorithms.Sort;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping(path="/sort-algorithms/")
public class SortController {
    
    @GetMapping(path="/")
    public JSONObject sortSample(){
        int[] arr = new int[]{23,54,123,34,1,22,65,90, 54};
        int[] originArray = Arrays.copyOfRange(arr, 0, arr.length);

        JSONObject obj = new JSONObject();
        obj.put("originArray", originArray);

        Sort sortObj = new Sort();

        obj.put("bubbleSortedArray", sortObj.bubbleSort(Arrays.copyOfRange(arr, 0, arr.length)));
        obj.put("selectionSortedArray", sortObj.selectionSort(Arrays.copyOfRange(arr, 0, arr.length)));
        obj.put("insertionSortedArray", sortObj.insertionSort(Arrays.copyOfRange(arr, 0, arr.length)));
        obj.put("mergeSortedArray", sortObj.mergeSort(Arrays.copyOfRange(arr, 0, arr.length)));

        return obj;
    }
}
