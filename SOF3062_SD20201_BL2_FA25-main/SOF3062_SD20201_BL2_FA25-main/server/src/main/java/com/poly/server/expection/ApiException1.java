package com.poly.server.expection;

public class ApiException1 extends RuntimeException{

    private final String code;


    public ApiException1(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
