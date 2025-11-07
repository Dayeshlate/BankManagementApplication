package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AccountNotFoundException;
import com.danny.BankApplication.exception.TransactionNotFoundException;
import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.model.transactions;
import com.danny.BankApplication.repository.accountsRepo;
import com.danny.BankApplication.repository.transactionsRepo;



@Service
public class transactionsService {

    @Autowired
    private transactionsRepo repo;

    @Autowired
    private accountsRepo accountRepo;

    public transactions saveTransaction(transactions transaction){
        if(transaction.getSenderAccount() != null && transaction.getSenderAccount().getId() != null){
            accounts senderAccount = accountRepo.findById(transaction.getSenderAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("sender is not found with id :"+transaction.getSenderAccount().getId()));

            transaction.setSenderAccount(senderAccount);
        }
        if(transaction.getRecipientAccount() != null && transaction.getRecipientAccount().getId() != null){
            accounts recipientAccount = accountRepo.findById(transaction.getRecipientAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("sender is not found with id :"+transaction.getRecipientAccount().getId()));

            transaction.setRecipientAccount(recipientAccount);
        }
        return repo.save(transaction);
    }

    public List<transactions> getAlltransaction(){
        return (List<transactions>) repo.findAll();
    }

    public Optional<transactions> getTransaction(int id){
        Optional<transactions> transaction = repo.findById(id);
        if (!transaction.isEmpty()) {
            throw new TransactionNotFoundException("Transaction not found with id :"+id);
        }
        return repo.findById(id);
    }

    public void deleteTransactions(int id){
        if(!repo.existsById(id)){
            throw new TransactionNotFoundException("Transaction Not found with id :"+id);
        }
        repo.deleteById(id);
    }

}
