package com.api.heroes.models;

import com.api.heroes.models.enumerators.Status;
import com.api.heroes.models.enumerators.TypeOfPet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pet")
public class PetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeOfPet type;
    private String bloodType;
    private String diagnosis;
    private String age;
    private String weight;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserModel owner;


}
