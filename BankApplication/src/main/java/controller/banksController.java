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
import model.banks;
import service.banksService;

@RestController
@RequestMapping("/banks")
public class banksController {

    @Autowired
    private banksService serv;

    @GetMapping("/getAll")
    public List<banks> getAllBanks() {
        return serv.getAllBanks();
    }

    @PostMapping("/save")
    public String saveBank(@RequestBody banks bank) {
        serv.saveBank(bank);        
        return "bank saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteBank(@PathVariable int id){
          serv.deleteBank(id);
          return "Bank deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<banks> getbank(@PathVariable int id) {
        return serv.getBank(id);
    }
    
    
}
