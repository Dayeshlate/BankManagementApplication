package com.danny.BankApplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danny.BankApplication.model.transactionTypes;
import com.danny.BankApplication.service.transactionTypesService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("transactionTypes")
public class transactionTypesController {

    @Autowired
    private transactionTypesService serv;
    @GetMapping("/getAll")
    public List<transactionTypes> getAlltransactionsTypes(@RequestParam String param) {
        return serv.getAllTransactionTypes();
    }

    @PostMapping("/save")
    public String saveTransactionsType(@RequestBody transactionTypes transactionType) {
        serv.saveTransactionType(transactionType);
        return "transactionn saved sussecfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<transactionTypes> getTransactionsType(@PathVariable int id) {
        return serv.getTransactionType(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteTransactionType(@PathVariable int id){
        return "Transaction Type delete succesfully !";
    }
    
}
