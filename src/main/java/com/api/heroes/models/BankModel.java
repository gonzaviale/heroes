package com.api.heroes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "bank")
public class BankModel {
    @Id
    @GeneratedValue
    private Long id;

    // Agrega aquí los campos adicionales

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
