package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.cards;


public interface cardsRepo extends JpaRepository<cards,Integer> {

}
