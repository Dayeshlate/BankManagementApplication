package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AccountNotFoundException;
import com.danny.BankApplication.exception.PaymentNotFoundException;
import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.model.payments;
import com.danny.BankApplication.repository.accountsRepo;
import com.danny.BankApplication.repository.paymentsRepo;

@Service
public class paymentsService {

    @Autowired
    private paymentsRepo repo;


    @Autowired
    private accountsRepo accountRepo;

    public List<payments> getAllPayments(){
        return (List<payments>) repo.findAll();
    }

    public Optional<payments> getPayment(int id){
        Optional<payments> payment = repo.findById(id);
        if(payment.isEmpty()){
            throw new PaymentNotFoundException("Payment not found with id :"+id);
        }
        return repo.findById(id);
    }

    public payments savePayment(payments payment){
        if(payment.getSenderAccount() != null && payment.getSenderAccount().getId() != null){
            accounts existingSenderAccount = accountRepo.findById(payment.getSenderAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("Sender is not found with id :"+payment.getSenderAccount().getId()));

            payment.setSenderAccount(existingSenderAccount);
        }

        if(payment.getRecipientAccount() != null && payment.getRecipientAccount().getId() != null){
            accounts existingRecipientAccount = accountRepo.findById(payment.getRecipientAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("Recipient Account is not found with id :"+payment.getRecipientAccount().getId()));

            payment.setRecipientAccount(existingRecipientAccount);
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
