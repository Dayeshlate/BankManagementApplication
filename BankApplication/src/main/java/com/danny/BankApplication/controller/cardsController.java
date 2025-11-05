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

import com.danny.BankApplication.model.cards;
import com.danny.BankApplication.service.cardsService;


@RestController
@RequestMapping("/cards")
public class cardsController {

    @Autowired
    private cardsService serv;

    @GetMapping("/getAll")
    public List<cards> getAllCards() {
        return serv.getAllCards();
    }

    @PostMapping("/save")
    public String saveCards(@RequestBody cards card) {
        serv.saveCard(card);        
        return "card saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteCard(@PathVariable int id){
          serv.deleteCard(id);
          return "card deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<cards> getCard(@PathVariable int id) {
        return serv.getCard(id);
    }
    
    
}
