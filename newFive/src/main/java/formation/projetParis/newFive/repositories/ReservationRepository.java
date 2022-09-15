package formation.projetParis.newFive.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.projetParis.newFive.entities.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation, Long>{
	Optional<Reservation> findByHeure(LocalTime heure);
	Optional<Reservation> findByDate(LocalDate date);

}
