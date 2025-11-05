package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.model.loanOfficers;
import com.danny.BankApplication.repository.loanOfficersRepo;


@Service
public class loanOfficersService {

    @Autowired
    private loanOfficersRepo repo;

    public loanOfficers saveLoanOfficer(loanOfficers loanOfficer){
        return repo.save(loanOfficer);
    }

    public void deleteLoanOfficer(int id){
        repo.deleteById(id);
    }

    public Optional<loanOfficers> getLoanOfficer(int id){
        return repo.findById(id);
    }

    public List<loanOfficers> getAllLoanOfficer(){
        return (List<loanOfficers>) repo.findAll();

    }

}
