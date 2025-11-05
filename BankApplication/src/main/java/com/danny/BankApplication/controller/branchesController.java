package com.danny.BankApplication.controller;

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

import com.danny.BankApplication.model.branches;
import com.danny.BankApplication.service.branchesService;



@RestController
@RequestMapping("/branches")
public class branchesController {

    @Autowired
    private branchesService serv;

    @GetMapping("/getAll")
    public List<branches> getAllBranches() {
        return serv.getAllBranches();
    }

    @PostMapping("/save")
    public String saveBranch(@RequestBody branches branch) {
        serv.saveBranch(branch);
        return "Branch saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
        public String deleteBranch(@PathVariable int id){
          serv.deleteBranch(id);
          return "Branch deleted succesfully !";
    }

    @GetMapping("/get/{id}")
    public Optional<branches> getBranches(@PathVariable int id) {
        return serv.getBranch(id);
    }
    
    
}
