package com.api.heroes.repositories;

import com.api.heroes.models.BloodPackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodPackRepository extends JpaRepository<BloodPackModel, Long> {
}
