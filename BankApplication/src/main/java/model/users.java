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
public class users {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name="branchId")
    private branches branch;

    private String name;

    private String email;

    @OneToMany(mappedBy = "users")
    private List<accounts> account;

    
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<payments> payment;

    @OneToMany(mappedBy = "users", cascade=CascadeType.ALL)
    private List<alerts> alert;
   
}
