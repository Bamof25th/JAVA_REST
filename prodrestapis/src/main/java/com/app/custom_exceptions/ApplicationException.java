package com.app.custom_exceptions;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String msg) {
        super(msg);
    }

}
