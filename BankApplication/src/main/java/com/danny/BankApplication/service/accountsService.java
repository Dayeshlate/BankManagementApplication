package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.repository.accountsRepo;



@Service
public class accountsService {

    @Autowired
    private accountsRepo repo;

    public void saveAccount(accounts account){
        repo.save(account);
    }

    public void deleteAccount(int id){
        repo.deleteById(id);
    }

    public List<accounts> getAccount(){
        return (List<accounts>) repo.findAll();
    }

    public Optional<accounts> getAccount(int id){
        return repo.findById(id);
    }
}
