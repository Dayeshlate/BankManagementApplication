package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.model.branches;
import com.danny.BankApplication.repository.branchesRepo;


@Service
public class branchesService {

    @Autowired
    private branchesRepo repo;

    public void saveBranch(branches branch){
         repo.save(branch);
    }

    public List<branches> getAllBranches(){
        return (List<branches>) repo.findAll();
    }

    public void deleteBranch(int id){
        repo.deleteById(id);
    }

    public Optional<branches> getBranch(int id){
        return repo.findById(id);
    }

}
