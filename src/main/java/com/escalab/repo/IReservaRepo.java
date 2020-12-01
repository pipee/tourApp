package com.escalab.repo;

import com.escalab.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepo extends JpaRepository<Reserva, Integer> {

}
