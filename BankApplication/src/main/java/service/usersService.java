package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.users;
import repository.usersRepo;

@Service
public class usersService {

    @Autowired
    private usersRepo repo;

    public List<users> getAllUsers(){
        return (List<users>) repo.findAll();
    }

    public users registerUser(users user){
        return repo.save(user);
    }

    public void deleteUser(int id){
        repo.deleteById(id);
    }

    public Optional<users> getUser(int id){
        return repo.findById(id);
    }

}
