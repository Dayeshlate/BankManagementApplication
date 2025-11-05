package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.banks;


public interface bankRepo extends JpaRepository<banks,Integer>{

}
