package com.danny.BankApplication.exception;

public class TransactionTypeNotFoundException extends RuntimeException{
    public TransactionTypeNotFoundException(String meassage){
        super(meassage);
    }
}
