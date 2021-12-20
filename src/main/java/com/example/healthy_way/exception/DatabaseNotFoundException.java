package com.example.healthy_way.exception;

public class DatabaseNotFoundException extends RuntimeException{

    public DatabaseNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
}
