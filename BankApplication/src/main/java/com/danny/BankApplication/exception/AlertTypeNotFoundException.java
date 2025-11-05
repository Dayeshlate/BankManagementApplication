package com.danny.BankApplication.exception;

public class AlertTypeNotFoundException extends RuntimeException{
    public AlertTypeNotFoundException(String messge){
        super(messge);
    }
}
