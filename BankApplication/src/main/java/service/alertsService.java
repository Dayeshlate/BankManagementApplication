package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.alerts;
import repository.alertsRepo;

@Service
public class alertsService {

    @Autowired
    private alertsRepo repo;

    public void saveAlert(alerts alert){
        repo.save(alert);
    } 

    public void deleteAlert(int id){
        repo.deleteById(id);
    }

    public List<alerts> getAllAlerts(){
        return (List<alerts>) repo.findAll();
    }

    public Optional<alerts> getAlert(int id){
        return repo.findById(id);
    }
}
