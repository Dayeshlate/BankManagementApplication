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

import model.loans;
import service.loansService;

@RestController
@RequestMapping("/loans")
public class loansController {

    @Autowired
    private loansService serv;

    @GetMapping("/getAll")
    public List<loans> getAllloans() {
        return serv.getAllLoans();
    }

    @PostMapping("/save")
    public String saveLoan(@RequestBody loans loan) {
        serv.saveLoan(loan);        
        return "loan saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteLoan(@PathVariable int id){
          serv.deleteLoan(id);
          return "Loan deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<loans> getLoans(@PathVariable int id) {
        return serv.getLoan(id);
    }
    
    
}
