package fivefoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fivefoot.entities.Reservation;
import fivefoot.repositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;


	public Reservation create(Reservation reservation) {

		return reservationRepo.save(reservation);
	}

	public Reservation getById(Long id) {
		return reservationRepo.findById(id).orElseThrow(ReservationException::new);
	}

	public Reservation update(Reservation reservation) {
		Reservation reservationEnBase = getById(reservation.getId());
		reservationEnBase.setNom(reservation.getNom());
		reservationEnBase.setPrix(reservation.getPrix());
		reservationEnBase.setDescription(reservation.getDescription());
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
