package formation.projetParis.newFive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.projetParis.newFive.entities.Ballon;
import formation.projetParis.newFive.exceptions.BallonException;
import formation.projetParis.newFive.repositories.BallonRepository;

@Service
public class BallonService {

	@Autowired
	private BallonRepository balRepo;


	public Ballon create(Ballon b) { //exception si no hay cuáles params??

		return balRepo.save(b);
	}

	public Ballon getById(Long id) {
		return balRepo.findById(id).orElseThrow(BallonException::new);
	}

	public Ballon update(Ballon b) {
		Ballon ballonEnBase = getById(b.getId());
		ballonEnBase.setNom(b.getNom());
		ballonEnBase.setPrix(b.getPrix());
		ballonEnBase.setStock(b.getStock());
		ballonEnBase.setCouleur(b.getCouleur());
		ballonEnBase.setTaille(b.getTaille());
		ballonEnBase.setDescription(b.getDescription());
		ballonEnBase.setImageUrl(b.getImageUrl());

		return balRepo.save(ballonEnBase);
	}
	

	public List<Ballon> getAll() {
		return balRepo.findAll();
	}

	public void delete(Ballon b) {
		balRepo.delete(b);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
}
