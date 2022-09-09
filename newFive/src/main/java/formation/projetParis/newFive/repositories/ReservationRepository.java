package formation.projetParis.newFive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.projetParis.newFive.entities.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Long>{

}
