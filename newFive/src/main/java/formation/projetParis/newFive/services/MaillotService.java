package formation.projetParis.newFive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.projetParis.newFive.entities.Ballon;
import formation.projetParis.newFive.entities.Maillot;
import formation.projetParis.newFive.exceptions.MaillotException;
import formation.projetParis.newFive.repositories.MaillotRepository;

@Service
public class MaillotService {

	@Autowired
	private MaillotRepository maillotRepo;


	public Maillot create(Maillot m) { //exception si no hay cuáles params??

		return maillotRepo.save(m);
	}

	public Maillot getById(Long id) {
		return maillotRepo.findById(id).orElseThrow(MaillotException::new);
	}

	public Maillot update(Maillot m) {
		Maillot maillotEnBase = getById(m.getId());
		maillotEnBase.setNom(m.getNom()); //quels params vont vaire l'update??
		maillotEnBase.setPrix(m.getPrix());
		maillotEnBase.setStock(m.getStock());
		maillotEnBase.setTaille(m.getTaille());
		maillotEnBase.setEquipe(m.getEquipe());

		maillotEnBase.setDescription(m.getDescription());
		maillotEnBase.setImageUrl(m.getImageUrl());
		return maillotRepo.save(maillotEnBase);
	}
	

	public List<Maillot> getAll() {
		return maillotRepo.findAll();
	}

	public void delete(Maillot m) {
		maillotRepo.delete(m);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
}
