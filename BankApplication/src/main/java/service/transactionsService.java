package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.transactions;
import repository.transactionsRepo;

@Service
public class transactionsService {

    @Autowired
    private transactionsRepo repo;

    public transactions saveTransaction(transactions transaction){
        return repo.save(transaction);
    }

    public List<transactions> getAlltransaction(){
        return (List<transactions>) repo.findAll();
    }

    public Optional<transactions> getTransaction(int id){
        return repo.findById(id);
    }

    public void deleteTransactions(int id){
        repo.deleteById(id);
    }

}
