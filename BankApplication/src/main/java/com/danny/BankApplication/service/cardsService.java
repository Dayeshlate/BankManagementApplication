package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.model.accounts;
import com.danny.BankApplication.model.cardTypes;
import com.danny.BankApplication.model.cards;
import com.danny.BankApplication.repository.accountsRepo;
import com.danny.BankApplication.repository.cardTypesRepo;
import com.danny.BankApplication.repository.cardsRepo;

@Service
public class cardsService {

    @Autowired
    private cardsRepo repo;

    @Autowired
    private accountsRepo accountRepo;

    @Autowired
    private cardTypesRepo cardTypeRepo;
    public void saveCard(cards card){
        accounts acc = accountRepo.findById(card.getAccount().getId())
                                  .orElseThrow(() -> new RuntimeException("Account not found"));
        cardTypes type = cardTypeRepo.findById(card.getCardType().getId())
                                  .orElseThrow(() -> new RuntimeException("Card type not found"));

         // reattach
        card.setAccount(acc);
        card.setCardType(type);

        repo.save(card);
    }

    public List<cards> getAllCards(){
        return (List<cards>) repo.findAll();
    }

    public void deleteCard(int id){
        repo.deleteById(id);
    }

    public Optional<cards> getCard(int id){
        return repo.findById(id);
    }

}
