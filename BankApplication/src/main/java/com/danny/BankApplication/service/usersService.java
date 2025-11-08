package com.danny.BankApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AccountNotFoundException;
import com.danny.BankApplication.exception.BranchNotFoundException;
import com.danny.BankApplication.exception.UserNotFoundException;
import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.model.branches;
import com.danny.BankApplication.model.users;
import com.danny.BankApplication.repository.accountsRepo;
import com.danny.BankApplication.repository.branchesRepo;
import com.danny.BankApplication.repository.usersRepo;


@Service
public class usersService {

    @Autowired
    private usersRepo repo;

    @Autowired
    private accountsRepo accountRepo;

    @Autowired
    private branchesRepo branchRepo;

    public List<users> getAllUsers(){
        return (List<users>) repo.findAll();
    }

    public users registerUser(users user){

        if(user.getBranch() != null && user.getBranch().getId() != null){
            branches existingBranch = branchRepo.findById(user.getBranch().getId())
            .orElseThrow(() -> new BranchNotFoundException("Branch is not found with id :"+user.getBranch().getId()));

            user.setBranch(existingBranch);
        }

        if (user.getAccount() != null && !user.getAccount().isEmpty()) {
        List<accounts> updatedAccounts = new ArrayList<>();

        for (accounts acc : user.getAccount()) {
            if (acc.getId() != null) {
                accounts existingAccount = accountRepo.findById(acc.getId())
                    .orElseThrow(() -> new AccountNotFoundException(
                        "Account not found with id: " + acc.getId()
                    ));
                updatedAccounts.add(existingAccount);
            }
        }
        user.setAccount(updatedAccounts);
    }
        return repo.save(user);
    }

    public void deleteUser(int id){
        if(!repo.existsById(id)){
            throw new UserNotFoundException("user Not found with id :"+id);
        }
        repo.deleteById(id);
    }

    public Optional<users> getUser(int id){
        Optional<users> user =repo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("user not found with id :"+id);
        }
        return repo.findById(id);
    }

}
