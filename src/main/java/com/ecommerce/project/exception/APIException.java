package com.ecommerce.project.exception;

public class APIException extends RuntimeException {
    public static  final int serialVersionUID=1;
    public  APIException(){

    }
    public APIException(String message) {
        super(message);
    }
}



