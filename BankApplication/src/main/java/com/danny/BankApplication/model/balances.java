package com.danny.BankApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class balances {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private float amount;

    @OneToOne(mappedBy = "balance")
    private accounts account;
}
