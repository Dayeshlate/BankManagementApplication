package com.danny.BankApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danny.BankApplication.model.alerts;
import com.danny.BankApplication.service.alertsService;



@RestController
@RequestMapping("/alerts")
public class alertsController {

    @Autowired
    private alertsService serv;

    @GetMapping("/getAll")
    public List<alerts> getAllAlerts() {
        return serv.getAllAlerts();
    }

    @PostMapping("/save")
    public String saveAlerts(@RequestBody alerts alerts) {
        serv.saveAlert(alerts);        
        return "alert saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteAlert(@PathVariable int id){
          serv.deleteAlert(id);
          return "Alert deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<alerts> getAlert(@PathVariable int id) {
        return serv.getAlert(id);
    }
    
    
}
