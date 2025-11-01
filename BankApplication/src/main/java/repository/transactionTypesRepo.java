package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.transactionTypes;

public interface transactionTypesRepo extends JpaRepository<transactionTypes,Integer> {

}
