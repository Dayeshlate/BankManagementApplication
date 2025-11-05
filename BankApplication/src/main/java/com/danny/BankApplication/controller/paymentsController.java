package com.danny.BankApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danny.BankApplication.model.payments;
import com.danny.BankApplication.service.paymentsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/payments")
public class paymentsController {

    @Autowired
    private paymentsService serv;

    @GetMapping("/getAll")
    public List<payments> getAllPayments() {
        return serv.getAllPayments();
    }

    @PostMapping("/save")
    public String savePayment(@RequestBody payments payment) {
        serv.savePayment(payment);        
        return "payment saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deletePayment(@PathVariable int id){
          serv.deletePayment(id);
          return "payment deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<payments> getPayment(@PathVariable int id) {
        return serv.getPayment(id);
    }
    
    
}
