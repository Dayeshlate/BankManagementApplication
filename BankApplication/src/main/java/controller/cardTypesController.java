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

import model.cardTypes;
import service.cardTypesService;

@RestController
@RequestMapping("/cardTypes")
public class cardTypesController {

    @Autowired
    private cardTypesService serv;

    @GetMapping("/getAll")
    public List<cardTypes> getAllCardTypes() {
        return serv.getAllCardTypes();
    }

    @PostMapping("/save")
    public String saveCardTypes(@RequestBody cardTypes cardType) {
        serv.saveCardType(cardType);
        return "card type saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteCardType(@PathVariable int id){
          serv.deleteCardTypes(id);
          return "card type deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<cardTypes> getCardType(@PathVariable int id) {
        return serv.getCardTypes(id);
    }
    
    
}
