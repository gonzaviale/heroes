package com.api.heroes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reservation")
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankModel bank;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
