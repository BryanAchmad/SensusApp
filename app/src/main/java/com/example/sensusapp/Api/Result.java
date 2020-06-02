package com.example.sensusapp.Api;

public class Result<T> {
    private int status;
    private String message;
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccessfull() {
        return status == 200;
    }
}
