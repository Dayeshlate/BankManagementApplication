package com.danny.BankApplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class branches {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bankId")
    private banks bank;

    private String address;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<users> user;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<loanOfficers> loanOfficer;
}
