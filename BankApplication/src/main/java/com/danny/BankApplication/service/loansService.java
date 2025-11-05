package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.model.loans;
import com.danny.BankApplication.repository.loansRepo;

@Service
public class loansService {

    @Autowired
    private loansRepo repo;

    public List<loans> getAllLoans(){
        return (List<loans>) repo.findAll();
    }

    public Optional<loans> getLoan(int id){
        return repo.findById(id);
    }

    public void deleteLoan(int id){
        repo.deleteById(id);
    }

    public loans saveLoan(loans loan){
        return repo.save(loan);
    }

}
