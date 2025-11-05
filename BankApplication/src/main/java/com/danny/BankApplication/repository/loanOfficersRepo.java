package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.loanOfficers;


public interface loanOfficersRepo extends JpaRepository<loanOfficers,Integer> {

}
