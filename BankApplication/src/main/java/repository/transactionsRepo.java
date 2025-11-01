package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.transactions;

public interface transactionsRepo extends JpaRepository<transactions,Integer>{

}
