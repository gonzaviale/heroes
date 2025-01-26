package com.api.heroes.repositories;

import com.api.heroes.models.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<ReservationModel, Long> {
}
