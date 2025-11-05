package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.loans;


public interface loansRepo extends JpaRepository<loans,Integer> {

}
