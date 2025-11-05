package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.model.cardTypes;
import com.danny.BankApplication.repository.cardTypesRepo;



@Service
public class cardTypesService {

    @Autowired
    private cardTypesRepo repo;

    public void saveCardType(cardTypes cardType){
        repo.save(cardType);
    }

    public List<cardTypes> getAllCardTypes(){
        return (List<cardTypes>) repo.findAll();
    }

    public void deleteCardTypes(int id){
        repo.deleteById(id);
    }

    public Optional<cardTypes> getCardTypes(int id){
        return repo.findById(id);
    }

}
