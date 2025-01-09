package com.api.heroes.repositories;

import com.api.heroes.models.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankRepository extends JpaRepository<BankModel, Long> {
}
