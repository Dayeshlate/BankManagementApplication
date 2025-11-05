package com.danny.BankApplication.exception;

public class LoanOfficerNotFoundException extends RuntimeException {
    public LoanOfficerNotFoundException(String message){
        super(message);
    }
}
