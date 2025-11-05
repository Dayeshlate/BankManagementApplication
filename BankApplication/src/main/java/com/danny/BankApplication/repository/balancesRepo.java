package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.balances;


public interface balancesRepo extends JpaRepository<balances,Integer> {

}
