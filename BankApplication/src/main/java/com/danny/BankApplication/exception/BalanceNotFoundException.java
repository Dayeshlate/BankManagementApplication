package com.danny.BankApplication.exception;

public class BalanceNotFoundException extends RuntimeException {
    public BalanceNotFoundException(String message){
        super(message);
    }
}
