package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.cards;
import repository.cardsRepo;

@Service
public class cardsService {

    @Autowired
    private cardsRepo repo;

    public void saveCard(cards card){
        repo.save(card);
    }

    public List<cards> getAllCards(){
        return (List<cards>) repo.findAll();
    }

    public void deleteCard(int id){
        repo.deleteById(id);
    }

    public Optional<cards> getCard(int id){
        return repo.findById(id);
    }

}
