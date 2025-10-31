package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class branches {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="bankId")
    private banks bank;

    private String address;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<users> user;

    @OneToMany(mappedBy = "branches", cascade = CascadeType.ALL)
    private List<loanOfficers> loanOfficer;
}
