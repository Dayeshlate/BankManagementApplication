package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AccountNotFoundException;
import com.danny.BankApplication.exception.LoanNotFoundException;
import com.danny.BankApplication.exception.LoanOfficerNotFoundException;
import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.model.loanOfficers;
import com.danny.BankApplication.model.loans;
import com.danny.BankApplication.repository.accountsRepo;
import com.danny.BankApplication.repository.loanOfficersRepo;
import com.danny.BankApplication.repository.loansRepo;

@Service
public class loansService {

    @Autowired
    private loansRepo repo;

    @Autowired
    private loanOfficersRepo loanOfficerRepo;

    @Autowired
    private accountsRepo accountRepo;

    public List<loans> getAllLoans(){
        return (List<loans>) repo.findAll();
    }

    public Optional<loans> getLoan(int id){
        Optional<loans> loan = repo.findById(id);
        if(loan.isEmpty()){
            throw new LoanNotFoundException("Loan not found with id :"+id);
        }
        return repo.findById(id);
    }

    public void deleteLoan(int id){
        if(!repo.existsById(id)){
            throw new LoanNotFoundException("loan Not found with id :"+id);
        }
        repo.deleteById(id);
    }

    public loans saveLoan(loans loan){
        if(loan.getLoanOfficer() != null && loan.getLoanOfficer().getId() != null){
            loanOfficers existingLoanOfficer = loanOfficerRepo.findById(loan.getLoanOfficer().getId())
            .orElseThrow(() -> new LoanOfficerNotFoundException("loan Oficer Not found with id :"+loan.getLoanOfficer().getId()));
          
            loan.setLoanOfficer(existingLoanOfficer);
        }

        if(loan.getAccount() != null && loan.getAccount().getId() != null){
            accounts existingAccount = accountRepo.findById(loan.getAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("Account not found with id :"+loan.getAccount().getId()));

            loan.setAccount(existingAccount);
        }
        return repo.save(loan);
    }

}
