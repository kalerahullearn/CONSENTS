package com.cms.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseEvent<T> {
    private String success;
    private int statusCode;
    private List<String> errors;
    private T data;
}
