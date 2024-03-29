package formation.projetParis.newFive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.projetParis.newFive.entities.Reservation;
import formation.projetParis.newFive.exceptions.ReservationException;
import formation.projetParis.newFive.repositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;

	// import terrain??? pour l'ajouter dans le create

	public Reservation create(Reservation reservation) { // exception si no hay numero de terreno?
		if (reservationRepo.findByDate(reservation.getDate()).isEmpty()
				&& reservationRepo.findByHeure(reservation.getHeure()).isEmpty()) {
			return reservationRepo.save(reservation);
		} else {

			return reservation;
		}

	}

	public Reservation getById(Long id) {
		return reservationRepo.findById(id).orElseThrow(ReservationException::new);
	}

	public Reservation update(Reservation reservation) {
		Reservation reservationEnBase = getById(reservation.getId());
		reservationEnBase.setDate(reservation.getDate());
		reservationEnBase.setPrix(reservation.getPrix());
		reservationEnBase.setHeure(reservation.getHeure());
		return reservationRepo.save(reservationEnBase);
	}

	public List<Reservation> getAll() {
		return reservationRepo.findAll();
	}

	public void delete(Reservation reservation) {
		reservationRepo.delete(reservation);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
}
