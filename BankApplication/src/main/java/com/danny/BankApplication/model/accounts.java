package com.danny.BankApplication.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // 👈 generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // 👈 generates no-argument constructor
@AllArgsConstructor // 👈 generates all-argument constructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class accounts {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userId")
    private users user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="balanceId")
    private balances balance;

    @OneToMany(mappedBy = "account")
    private List<loans> loan;

    @OneToMany(mappedBy = "account")
    private List<cards> card;
}
