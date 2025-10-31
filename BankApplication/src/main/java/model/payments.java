package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class payments {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private float amount;

    @ManyToOne
    @JoinColumn(name="recipientId")
    private users user;

    @ManyToOne
    @JoinColumn(name="accountId")
    private accounts account;
}
