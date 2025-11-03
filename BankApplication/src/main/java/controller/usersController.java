package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.users;
import service.usersService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/users")
public class usersController {

    @Autowired
    private usersService serv;

    @PostMapping("/register")
    public String getAllUsers(@RequestBody users user) {
        serv.registerUser(user);
        return "user save succesfully !";
    }

    @GetMapping("user/{id}")
    public Optional<users> getUser(@PathVariable int id) {
        return  serv.getUser(id);
    }
    
    @GetMapping("/allUser")
    public List<users> getAllUsers() {
        return serv.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        serv.deleteUser(id);
        return "User deleted succesfully !";
    }
    
}
