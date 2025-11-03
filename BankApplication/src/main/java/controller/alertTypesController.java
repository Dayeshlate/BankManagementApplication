package controller;

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

import model.alertTypes;
import service.alertTypesService;

@RestController
@RequestMapping("/alertTypes")
public class alertTypesController {

    @Autowired
    private alertTypesService serv;

    @GetMapping("/getAll")
    public List<alertTypes> getAllAlertTypes() {
        return serv.getAllAlertTypes();
    }

    @PostMapping("/save")
    public String saveAlertType(@RequestBody alertTypes alertType) {
        serv.saveAlertType(alertType); 
        return "Alert type saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteAlertType(@PathVariable int id){
          serv.deleteAlertType(id);
          return "Alert Type deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<alertTypes> getAlertType(@PathVariable int id) {
        return serv.getAlertType(id);
    }
    
    
}
