package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.TransactionTypeNotFoundException;
import com.danny.BankApplication.model.transactionTypes;
import com.danny.BankApplication.repository.transactionTypesRepo;


@Service
public class transactionTypesService {

    @Autowired
    private transactionTypesRepo repo;

    public void saveTransactionType(transactionTypes transactionType){
        repo.save(transactionType);
    }

    public Optional<transactionTypes> getTransactionType(int id){
        Optional<transactionTypes> transactionType = repo.findById(id);
        if (transactionType.isEmpty()) {
            throw new TransactionTypeNotFoundException("Transaction Type not found with id :"+id);
        }
        return repo.findById(id);
    }

    public List<transactionTypes> getAllTransactionTypes(){
        return (List<transactionTypes>) repo.findAll();
    }

    public void deleteTransactionTypes(int id){
        if(!repo.existsById(id)){
            throw new TransactionTypeNotFoundException("Transaction type Not found with id :"+id);
        }
        repo.deleteById(id);
    }

}
