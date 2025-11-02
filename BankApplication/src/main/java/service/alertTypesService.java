package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.alertTypes;
import repository.alertTypesRepo;

@Service
public class alertTypesService {

    @Autowired
    private alertTypesRepo repo;

    public void saveAlertType(alertTypes alertType){
        repo.save(alertType);
    }

    public Optional<alertTypes> getAlertType(int id){
        return repo.findById(id);
    }

    public List<alertTypes> getAllAlertTypes(){
        return (List<alertTypes>) repo.findAll();
    }

    public void deleteAlertType(int id){
        repo.deleteById(id);
    }
}
