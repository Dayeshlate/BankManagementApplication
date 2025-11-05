package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.transactionTypes;


public interface transactionTypesRepo extends JpaRepository<transactionTypes,Integer> {

}
