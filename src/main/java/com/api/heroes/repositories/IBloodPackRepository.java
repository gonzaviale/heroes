package com.api.heroes.repositories;

import com.api.heroes.models.BankModel;
import com.api.heroes.models.BloodPackModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBloodPackRepository extends JpaRepository<BloodPackModel, Long> {
    List<BloodPackModel> getBloodPackModelsByBank(BankModel bank);
}
