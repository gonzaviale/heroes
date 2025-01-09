package com.api.heroes.repositories;

import com.api.heroes.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<PetModel, Long> {
}
