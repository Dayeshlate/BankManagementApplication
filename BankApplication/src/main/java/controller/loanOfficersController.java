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

@RestController
@RequestMapping("/loanOfficers")
public class loanOfficersController {

    @Autowired
    private loanOfficersController serv;

    @GetMapping("/getAll")
    public List<loanOfficersController> getAllLoanOfficers() {
        return serv.getAllLoanOfficers();
    }

    @PostMapping("/save")
    public String saveLoanOfficer(@RequestBody loanOfficersController loanOfficer) {
        serv.saveLoanOfficer(loanOfficer);        
        return "Loan officer saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteLoanOfficer(@PathVariable int id){
          serv.deleteLoanOfficer(id);
          return "loan officer deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<loanOfficersController> getLoanOfficer(@PathVariable int id) {
        return serv.getLoanOfficer(id);
    }
    
    
}
