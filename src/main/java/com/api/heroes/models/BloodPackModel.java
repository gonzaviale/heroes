package com.api.heroes.models;

import com.api.heroes.models.enumerators.BloodPackStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "bloodpack")
public class BloodPackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeProduct;
    private String bloodType;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private BloodPackStatus status;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankModel bank;

}
