package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.banks;

public interface bankRepo extends JpaRepository<banks,Integer>{

}
