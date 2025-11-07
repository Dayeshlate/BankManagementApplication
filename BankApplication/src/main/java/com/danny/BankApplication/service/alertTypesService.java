package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AlertTypeNotFoundException;
import com.danny.BankApplication.model.alertTypes;
import com.danny.BankApplication.repository.alertTypesRepo;


@Service
public class alertTypesService {

    @Autowired
    private alertTypesRepo repo;

    public void saveAlertType(alertTypes alertType){
        repo.save(alertType);
    }

    public Optional<alertTypes> getAlertType(int id){
        Optional<alertTypes> alertType = repo.findById(id);
        if (!alertType.isEmpty()) {
            throw new AlertTypeNotFoundException("alert type is not found with id :"+id);
        }
        return repo.findById(id);
    }

    public List<alertTypes> getAllAlertTypes(){
        return (List<alertTypes>) repo.findAll();
    }

    public void deleteAlertType(int id){
        if(!repo.existsById(id)){
            throw new AlertTypeNotFoundException("Alert type is not found with id :"+id);
        }
        repo.deleteById(id);
    }
}
