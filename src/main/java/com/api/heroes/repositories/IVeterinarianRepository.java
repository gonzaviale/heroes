package com.api.heroes.repositories;

import com.api.heroes.models.UserModel;
import com.api.heroes.models.VeterinarianModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IVeterinarianRepository extends JpaRepository<VeterinarianModel, Long> {

    Optional<VeterinarianModel> findByUser(UserModel userModel);
}
