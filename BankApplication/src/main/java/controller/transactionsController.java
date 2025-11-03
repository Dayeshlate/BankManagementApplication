package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.transactions;
import service.transactionsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/transactions")
public class transactionsController {

    @Autowired
    private transactionsService serv;
    @GetMapping("/getAll")
    public List<transactions> getAllTransaction() {
        return serv.getAlltransaction();
    }
    
    @GetMapping("/get/{id}")
    public Optional<transactions> getTransaction(@PathVariable int id) {
        return serv.getTransaction(id);
    }
    
    @PostMapping("/save")
    public String saveTransaction(@RequestBody transactions transaction) {
        serv.saveTransaction(transaction);
        return "transaction saved succesfully !";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable int id){
        serv.deleteTransactions(id);
        return "transaction delete succesfully !";
    }

}
