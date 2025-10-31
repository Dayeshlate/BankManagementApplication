package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class transactionTypes {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String  name;

    @OneToMany(mappedBy = "transactionTypes", cascade = CascadeType.ALL)
    private List<transactions> transactions;

    

}
