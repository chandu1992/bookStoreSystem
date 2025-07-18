package com.mksss.cummins.bookStoreSystem.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler<T> {

    private T data;
    private int statusCode;
    private String message;

    private LocalDateTime timestamp;

    public ResponseHandler(T data, int statusCode, String message, LocalDateTime date) {
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = date;
    }

    public T getData() {
        return data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}