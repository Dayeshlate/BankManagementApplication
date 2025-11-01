package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.accounts;

public interface accountsRepo extends JpaRepository<accounts,Integer> {

}
