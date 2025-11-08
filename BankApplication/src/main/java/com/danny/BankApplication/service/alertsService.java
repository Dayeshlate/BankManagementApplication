package com.danny.BankApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danny.BankApplication.exception.AlertNotFoundException;
import com.danny.BankApplication.exception.AlertTypeNotFoundException;
import com.danny.BankApplication.exception.UserNotFoundException;
import com.danny.BankApplication.model.alertTypes;
import com.danny.BankApplication.model.alerts;
import com.danny.BankApplication.model.users;
import com.danny.BankApplication.repository.alertTypesRepo;
import com.danny.BankApplication.repository.alertsRepo;
import com.danny.BankApplication.repository.usersRepo;



@Service
public class alertsService {

    @Autowired
    private alertsRepo repo;

    @Autowired
    private usersRepo userRepo;

    @Autowired
    private alertTypesRepo alertTypeRepo;

    public void saveAlert(alerts alert){
        if(alert.getUser() != null && alert.getUser().getId() != null){
            users existingUser = userRepo.findById(alert.getUser().getId())
            .orElseThrow(() -> new UserNotFoundException("user not found with id :"+alert.getUser().getId()));
       
            alert.setUser(existingUser);
            }

        if(alert.getAlertType() != null && alert.getAlertType().getId() != null){
            alertTypes existingAlertType = alertTypeRepo.findById(alert.getAlertType().getId())
            .orElseThrow(() -> new AlertTypeNotFoundException("Alert Type is not found with id :"+alert.getAlertType().getId()));
            
            alert.setAlertType(existingAlertType);
        }
        repo.save(alert);
    } 

    public void deleteAlert(int id){
        if(!repo.existsById(id)){
            throw new AlertNotFoundException("Alert is not found with id :"+id);
        }
        repo.deleteById(id);
    }

    public List<alerts> getAllAlerts(){
        return (List<alerts>) repo.findAll();
    }

    public Optional<alerts> getAlert(int id){
         Optional<alerts> alert = repo.findById(id);
        if(alert.isEmpty()){
            throw new AlertNotFoundException("Alert is not found with id :"+id);
        }
        return repo.findById(id);
    }
}
