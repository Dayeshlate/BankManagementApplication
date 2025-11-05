package com.danny.BankApplication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danny.BankApplication.model.balances;
import com.danny.BankApplication.service.balancesService;


@RestController
@RequestMapping("/balances")
public class balancesController {

    @Autowired
    private balancesService serv;

    @PostMapping("/save")
    public String saveBalances(@RequestBody balances balance) {
        serv.saveBalance(balance);
        return "Balance saved succesfully";
    }

    @GetMapping("/get/{id}")
    public Optional<balances> getBalances(@PathVariable int id) {
        return serv.getBalance(id);
    }
    
    
}
