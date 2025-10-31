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
public class loanOfficers {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name="brancheId")
    private List<branches> branch;

    @OneToMany(mappedBy = "loanOfficers", cascade = CascadeType.ALL)
    private List<loans> loan;
}
