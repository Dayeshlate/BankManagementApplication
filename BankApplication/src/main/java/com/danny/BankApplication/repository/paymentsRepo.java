package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.payments;


public interface paymentsRepo extends JpaRepository<payments,Integer>{

}
