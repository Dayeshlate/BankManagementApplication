package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.payments;
import repository.paymentsRepo;

@Service
public class paymentsService {

    @Autowired
    private paymentsRepo repo;

    public List<payments> getAllPayments(){
        return (List<payments>) repo.findAll();
    }

    public Optional<payments> getPayment(int id){
        return repo.findById(id);
    }

    public payments payment(payments payment){
        return repo.save(payment);
    }

    public void deletePayment(int id){
        repo.deleteById(id);
    }

}
