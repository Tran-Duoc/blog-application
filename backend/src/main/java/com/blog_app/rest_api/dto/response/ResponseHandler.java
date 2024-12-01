package com.blog_app.rest_api.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<Object> baseResponse(HttpStatus status, String message, T data) {

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", data);

        return ResponseEntity.status(status).body(map);
    }

    public  static  <T> ResponseEntity<Object> errorResponse(HttpStatus status, String message){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status.value());
        map.put("message", message);
        return ResponseEntity.status(status).body(map);
    }
}

