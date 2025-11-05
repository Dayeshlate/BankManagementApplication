package com.danny.BankApplication.exception;

public class TransactionNotFound extends RuntimeException{
    public TransactionNotFound(String message){
        super(message);
    }
}
