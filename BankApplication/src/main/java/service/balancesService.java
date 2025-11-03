package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.balances;
import repository.balancesRepo;

@Service
public class balancesService {

    @Autowired
    private balancesRepo repo;

    public Optional<balances> getBalance(int id){
        return repo.findById(id);
    }

    public balances saveBalance(balances balance){
        return repo.save(balance);
    }
}
