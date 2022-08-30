package fivefoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fivefoot.entities.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Long>{

}
