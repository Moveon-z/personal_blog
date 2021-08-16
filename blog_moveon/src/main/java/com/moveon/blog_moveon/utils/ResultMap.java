//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.moveon.blog_moveon.utils;

import java.io.Serializable;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class ResultMap<T> implements Serializable {
    private static final long serialVersionUID = 500L;
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    private String type;
    private String message;
    private T data;
    private String tracker;
    private String redirect;

    public ResultMap() {
    }

    public ResultMap(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public ResultMap(String type, String message, String tracker) {
        this.type = type;
        this.message = message;
        this.tracker = tracker;
    }

    public ResultMap(String type, String message, T data, String tracker) {
        this.type = type;
        this.message = message;
        this.data = data;
        this.tracker = tracker;
    }

    public ResultMap(String type, String message, T data) {
        this.type = type;
        this.message = message;
        this.data = data;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public static ResultMap buildSuccessResult(String message) {
        return new ResultMap("success", message, getTracker());
    }

    public static <T> ResultMap<T> buildSuccessResult(String message, T data) {
        return new ResultMap("success", message, data, getTracker());
    }

    public static ResultMap buildFailureResult(String message) {
        return new ResultMap("failure", message, getTracker());
    }

    public static <T> ResultMap<T> buildFailureResult(String message, T data) {
        return new ResultMap("failure", message, data, getTracker());
    }

    private static String getTracker() {
        RequestAttributes rattrs = RequestContextHolder.getRequestAttributes();
        String tracker = null;
        if (rattrs != null) {
            tracker = (String)RequestContextHolder.getRequestAttributes().getAttribute("requestKey", 0);
        }

        return tracker;
    }
}
