package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repo.findById(id);
    }

    public List<transactionTypes> getAllTransactionTypes(){
        return (List<transactionTypes>) repo.findAll();
    }

    public void deleteTransactionTypes(int id){
        repo.deleteById(id);
    }

}
