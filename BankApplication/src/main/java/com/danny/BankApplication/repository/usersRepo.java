package com.danny.BankApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.danny.BankApplication.model.users;

public interface usersRepo extends JpaRepository<users,Integer> {

}
