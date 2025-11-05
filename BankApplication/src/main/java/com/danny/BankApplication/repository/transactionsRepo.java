package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.transactions;


public interface transactionsRepo extends JpaRepository<transactions,Integer>{

}
