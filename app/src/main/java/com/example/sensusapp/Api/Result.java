package com.example.sensusapp.Api;

public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccessfull() {
        return data != null;
    }
}
