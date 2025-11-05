package com.danny.BankApplication.exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String message){
        super(message);
    }
}
