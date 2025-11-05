package com.danny.BankApplication.exception;

public class CardTypeNotFoundException extends RuntimeException {
    public CardTypeNotFoundException(String message){
        super(message);
    }
}
