package com.datastructure.demo.repository;

import java.util.HashMap;
import java.util.Map;

import com.datastructure.demo.service.linear.HeapTreeService;
import com.datastructure.demo.service.linear.LinkedListService;

public class DataStorage {
    public static Map<String, LinkedListService> dataMap = new HashMap<String, LinkedListService>();   
    public static Map<String, HeapTreeService> HeapTree = new HashMap<String, HeapTreeService>();
}
