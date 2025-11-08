package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.BankNotFoundException;
import com.danny.BankApplication.exception.BranchNotFoundException;
import com.danny.BankApplication.model.banks;
import com.danny.BankApplication.model.branches;
import com.danny.BankApplication.repository.bankRepo;
import com.danny.BankApplication.repository.branchesRepo;


@Service
public class branchesService {

    @Autowired
    private branchesRepo repo;

    @Autowired
    private bankRepo bankRepo;

    public void saveBranch(branches branch){
        if(branch.getBank() != null && branch.getBank().getId() != null){
            banks existingBank = bankRepo.findById(branch.getBank().getId())
            .orElseThrow(() -> new BankNotFoundException("Bank not found with id :"+branch.getBank().getId()));

            branch.setBank(existingBank);
        }
        repo.save(branch);
    }

    public List<branches> getAllBranches(){
        return (List<branches>) repo.findAll();
    }

    public void deleteBranch(int id){
        if(!repo.existsById(id)){
            throw new BranchNotFoundException("Branch Not found with id :"+id);
        }
        repo.deleteById(id);
    }

    public Optional<branches> getBranch(int id){
        Optional<branches> branch = repo.findById(id);
        if(branch.isEmpty()){
            throw new BranchNotFoundException("Branch Not found with id :"+id);
        }
        return branch;
    }

}
