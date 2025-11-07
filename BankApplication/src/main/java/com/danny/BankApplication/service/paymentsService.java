package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AccountNotFoundException;
import com.danny.BankApplication.exception.PaymentNotFoundException;
import com.danny.BankApplication.exception.UserNotFoundException;
import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.model.payments;
import com.danny.BankApplication.model.users;
import com.danny.BankApplication.repository.accountsRepo;
import com.danny.BankApplication.repository.paymentsRepo;
import com.danny.BankApplication.repository.usersRepo;

@Service
public class paymentsService {

    @Autowired
    private paymentsRepo repo;

    @Autowired
    private usersRepo userRepo;

    @Autowired
    private accountsRepo accountRepo;

    public List<payments> getAllPayments(){
        return (List<payments>) repo.findAll();
    }

    public Optional<payments> getPayment(int id){
        Optional<payments> payment = repo.findById(id);
        if(!payment.isEmpty()){
            throw new PaymentNotFoundException("Payment not found with id :"+id);
        }
        return repo.findById(id);
    }

    public payments savePayment(payments payment){
        if(payment.getSenderUser() != null && payment.getSenderUser().getId() != null){
            users existingSender = userRepo.findById(payment.getSenderUser().getId())
            .orElseThrow(() -> new UserNotFoundException("Sender is not found with id :"+payment.getSenderUser().getId()));

            payment.setSenderUser(existingSender);
        }

        if(payment.getRecipientUser() != null && payment.getRecipientUser().getId() != null){
            users existingRecipient = userRepo.findById(payment.getRecipientUser().getId())
            .orElseThrow(() -> new UserNotFoundException("Recipient is not found with id :"+payment.getRecipientUser().getId()));

            payment.setRecipientUser(existingRecipient);
        }

        if(payment.getAccount() != null && payment.getAccount().getId() != null){
            accounts existingAccount = accountRepo.findById(payment.getAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("Account not found with id :"+payment.getAccount().getId()));

            payment.setAccount(existingAccount);
        }        
        return repo.save(payment);
    }

    public void deletePayment(int id){
        if(!repo.existsById(id)){
            throw new PaymentNotFoundException("payment Not found with id :"+id);
        }
        repo.deleteById(id);
    }

}
