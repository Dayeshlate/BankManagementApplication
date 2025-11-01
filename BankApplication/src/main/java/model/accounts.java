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
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // 👈 generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // 👈 generates no-argument constructor
@AllArgsConstructor // 👈 generates all-argument constructor
public class accounts {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userId")
    private users user;

    @OneToOne
    @JoinColumn(name="balanceId")
    private balances balance;

    @OneToMany(mappedBy = "accounts" , cascade =CascadeType.ALL)
    private List<loans> loan;

    @OneToMany(mappedBy = "accounts" , cascade = CascadeType.ALL)
    private List<cards> card;
}
