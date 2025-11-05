package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.accounts;


public interface accountsRepo extends JpaRepository<accounts,Integer> {

}
