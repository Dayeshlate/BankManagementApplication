package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.BranchNotFoundException;
import com.danny.BankApplication.exception.LoanOfficerNotFoundException;
import com.danny.BankApplication.model.branches;
import com.danny.BankApplication.model.loanOfficers;
import com.danny.BankApplication.repository.branchesRepo;
import com.danny.BankApplication.repository.loanOfficersRepo;


@Service
public class loanOfficersService {

    @Autowired
    private loanOfficersRepo repo;

    @Autowired
    private branchesRepo branchRepo;

    public loanOfficers saveLoanOfficer(loanOfficers loanOfficer){
        if(loanOfficer.getBranch() != null && loanOfficer.getBranch().getId() != null){
            branches existingBranch = branchRepo.findById(loanOfficer.getBranch().getId())
            .orElseThrow(() -> new BranchNotFoundException("Branch not found with id :"+loanOfficer.getBranch().getId()));
            
            loanOfficer.setBranch(existingBranch);

        }
        return repo.save(loanOfficer);
    }

    public void deleteLoanOfficer(int id){
        if(!repo.existsById(id)){
            throw new LoanOfficerNotFoundException("loan officer Not found with id :"+id);
        }
        repo.deleteById(id);
    }

    public Optional<loanOfficers> getLoanOfficer(int id){
        Optional<loanOfficers> loanOfficer = repo.findById(id);
        if(loanOfficer.isEmpty()){
            throw new LoanOfficerNotFoundException("Loan officer not found with id :"+id);
        }
        return repo.findById(id);
    }

    public List<loanOfficers> getAllLoanOfficer(){
        return (List<loanOfficers>) repo.findAll();

    }

}
