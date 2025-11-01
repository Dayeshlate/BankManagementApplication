package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.payments;

public interface paymentsRepo extends JpaRepository<payments,Integer>{

}
