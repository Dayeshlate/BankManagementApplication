package com.danny.BankApplication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class loans {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private float amount;

    @ManyToOne
    @JoinColumn(name="loanOfficerId")
    private loanOfficers loanOfficer;

    @ManyToOne
    @JoinColumn(name="accountId")
    private accounts account;
    


}
