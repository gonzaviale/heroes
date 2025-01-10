package com.api.heroes.repositories;

import com.api.heroes.models.BankModel;
import com.api.heroes.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBankRepository extends JpaRepository<BankModel, Long> {
    Optional<BankModel> findByUser(UserModel userModel);
}
