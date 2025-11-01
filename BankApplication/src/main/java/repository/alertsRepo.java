package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.alerts;

public interface alertsRepo extends JpaRepository<alerts,Integer> {

}
