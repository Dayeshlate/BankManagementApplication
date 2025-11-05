package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.cardTypes;


public interface cardTypesRepo extends JpaRepository<cardTypes,Integer>{

}
