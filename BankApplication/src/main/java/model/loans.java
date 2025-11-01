package model;

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
    private int account;
    


}
