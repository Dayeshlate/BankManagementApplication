package com.danny.BankApplication.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp",LocalDateTime.now());
        errorResponse.put("status",HttpStatus.NOT_FOUND.value());
        errorResponse.put("error" ,ex.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionTypeNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleTransactionTypeNotFound(TransactionTypeNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp",LocalDateTime.now());
        errorResponse.put("status",HttpStatus.NOT_FOUND.value());
        errorResponse.put("error", ex.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
        public ResponseEntity<Map<String,Object>> handleTransactionNotFound(TransactionNotFoundException ex){
            Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handlePaymentNotFound(PaymentNotFoundException ex){
            Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleLoanNotFound(LoanNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LoanOfficerNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleLoanOfficerNotFound(LoanOfficerNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardTypeNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCardTypeNotNotFound(CardTypeNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCardNotFound(CardNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BranchNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleBranchNotNotFound(BranchNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlertTypeNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleAlertTypeNotNotFound(AlertTypeNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlertNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleAlertNotFound(AlertNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleAccountNotFound(AccountNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

     @ExceptionHandler(BankNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleBankNotFound(BankNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

     @ExceptionHandler(BalanceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleBalanceNotFound(BalanceNotFoundException ex){
        Map<String,Object> errorResponse = new HashMap<>();
            errorResponse.put("timestamp",LocalDateTime.now());
            errorResponse.put("status",HttpStatus.NOT_FOUND);
            errorResponse.put("error", ex.getMessage());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
