package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.loans;

public interface loansRepo extends JpaRepository<loans,Integer> {

}
