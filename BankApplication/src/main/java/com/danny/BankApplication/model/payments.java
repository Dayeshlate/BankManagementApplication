package com.danny.BankApplication.model;

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
public class payments {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private float amount;

    @ManyToOne
    @JoinColumn(name="recipientId")
    private users recipientUser;

    @ManyToOne
    @JoinColumn(name="senderId")
    private users senderUser;

    @ManyToOne
    @JoinColumn(name="accountId")
    private accounts account;
}
