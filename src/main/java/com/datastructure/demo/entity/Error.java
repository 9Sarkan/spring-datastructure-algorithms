package com.datastructure.demo.entity;

public class Error {
    String message;
    int status;

    public Error(int status, String message){
        this.status= status;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public int getStatus(){
        return this.status;
    }
}
