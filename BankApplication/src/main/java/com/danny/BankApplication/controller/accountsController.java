package com.danny.BankApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.service.accountsService;


@RestController
@RequestMapping("/accounts")
public class accountsController {

    @Autowired
    private accountsService serv;

    @GetMapping("/getAll")
    public List<accounts> getAllAccounts() {
        return serv.getAccount();
    }

    @PostMapping("/save")
    public String saveAccoount(@RequestBody accounts account) {
        serv.saveAccount(account);        
        return "account saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteAccount(@PathVariable int id){
          serv.deleteAccount(id);
          return "Account deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<accounts> getAccount(@PathVariable int id) {
        return serv.getAccount(id);
    }
    
    
}
