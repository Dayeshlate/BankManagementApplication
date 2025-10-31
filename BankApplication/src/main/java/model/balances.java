package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class balances {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private float amount;

    @OneToOne(mappedBy = "balances")
    private accounts account;
}
