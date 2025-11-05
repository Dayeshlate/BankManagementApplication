package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danny.BankApplication.model.branches;



public interface branchesRepo extends JpaRepository<branches,Integer> {

}
