package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AccountNotFoundException;
import com.danny.BankApplication.exception.BalanceNotFoundException;
import com.danny.BankApplication.exception.UserNotFoundException;
import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.model.balances;
import com.danny.BankApplication.model.users;
import com.danny.BankApplication.repository.accountsRepo;
import com.danny.BankApplication.repository.balancesRepo;
import com.danny.BankApplication.repository.usersRepo;



@Service
public class accountsService {

    @Autowired
    private accountsRepo repo;

    @Autowired
    private balancesRepo balanceRepo;

    @Autowired
    private usersRepo userRepo;

    public void saveAccount(accounts account){
        if(account.getBalance() != null && account.getBalance().getId() != null){
            balances existingBalance = balanceRepo.findById(account.getBalance().getId())
            .orElseThrow(() -> new BalanceNotFoundException("Balance is not preset with id :"+account.getBalance().getId()));

            account.setBalance(existingBalance);
        }
        if(account.getUser() != null && account.getUser().getId() != null){
            users existingUser = userRepo.findById(account.getUser().getId())
            .orElseThrow(() -> new UserNotFoundException("user is not exists with id :"+account.getUser().getId()));

            account.setUser(existingUser);
        }
        repo.save(account);
    }

    public void deleteAccount(int id){
        if(!repo.existsById(id)){
            throw new AccountNotFoundException("Account is not found with id :"+id);
        }
        repo.deleteById(id);
    }

    public List<accounts> getAccount(){
        return (List<accounts>) repo.findAll();
    }

    public Optional<accounts> getAccount(int id){
        Optional<accounts> account = repo.findById(id);
        if(account.isEmpty()){
            throw new AccountNotFoundException("Account is not found with id :"+id);
        }
        return repo.findById(id);
    }
}
