package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AccountNotFoundException;
import com.danny.BankApplication.exception.CardNotFoundException;
import com.danny.BankApplication.exception.CardTypeNotFoundException;
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

        if(card.getAccount() != null && card.getAccount().getId() != null){
            accounts acc = accountRepo.findById(card.getAccount().getId())
            .orElseThrow(() -> new AccountNotFoundException("Account is not found with id :"+card.getAccount().getId()));
            
            card.setAccount(acc);
        }
        if(card.getCardType() != null && card.getCardType().getId() != null){
            cardTypes type = cardTypeRepo.findById(card.getCardType().getId())
            .orElseThrow(() -> new CardTypeNotFoundException("Card Type not found with id :"+card.getCardType().getId()));

            card.setCardType(type);
        }

        repo.save(card);
    }

    public List<cards> getAllCards(){
        return (List<cards>) repo.findAll();
    }

    public void deleteCard(int id){
        if(!repo.existsById(id)){
            throw new CardNotFoundException("card Not found with id :"+id);
        }
        repo.deleteById(id);
    }

    public Optional<cards> getCard(int id){
        Optional<cards> card = repo.findById(id);
        if(!card.isEmpty()){
            throw new CardNotFoundException("card is not found with id :"+id);
        }
        return repo.findById(id);
    }

}
