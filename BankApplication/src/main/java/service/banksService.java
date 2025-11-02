package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.banks;
import repository.bankRepo;

@Service
public class banksService {

    @Autowired
    private bankRepo repo;

    public void saveBank(banks bank){
        repo.save(bank);
    }

    public List<banks> getAllBanks(){
        return (List<banks>) repo.findAll();
    }

    public Optional<banks> getBank(int id){
        return repo.findById(id);
    }

    public void deleteBank(int id){
        repo.deleteById(id);
    }
}
