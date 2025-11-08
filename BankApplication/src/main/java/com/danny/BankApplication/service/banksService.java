package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.BankNotFoundException;
import com.danny.BankApplication.model.banks;
import com.danny.BankApplication.repository.bankRepo;



@Service
public class banksService {

    @Autowired
    private bankRepo repo;

    public void saveBank(banks bank){
        repo.save(bank);
    }

    public List<banks> getAllBanks(){
        return (List<banks>) repo.findAll();
    }

    public Optional<banks> getBank(int id){
        Optional<banks> bank = repo.findById(id);
        if (bank.isEmpty()) {
            throw new BankNotFoundException("Bank not found with id :"+id);
        }
        return bank;
    }

    public void deleteBank(int id){
        if(!repo.existsById(id)){
            throw new BankNotFoundException("Bank is not found with id :"+id);
        }
        repo.deleteById(id);
    }
}
