package com.moveon.blog_moveon.utils;

import java.io.Serializable;

public class ResultMap<T> implements Serializable {

    private String type;
    private String message;
    private T data;

    public ResultMap() {

    }

    public ResultMap(String type,String message,T data) {
        this.type = type;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultMap<T> buildSuccessResult(String message, T data) {
        return new ResultMap("success",message,data);
    }

    public static ResultMap buildFailResult(String message) {
        return new ResultMap("fail",message,null);
    }
}
