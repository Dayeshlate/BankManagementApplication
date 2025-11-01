package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.cards;

public interface cardsRepo extends JpaRepository<cards,Integer> {

}
