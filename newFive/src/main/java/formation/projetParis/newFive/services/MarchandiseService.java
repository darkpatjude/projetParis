package formation.projetParis.newFive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.projetParis.newFive.entities.Marchandise;
import formation.projetParis.newFive.exceptions.MarchandiseException;
import formation.projetParis.newFive.repositories.MarchandiseRepository;

@Service
public class MarchandiseService {

	
	@Autowired
	private MarchandiseRepository marchandiseRepo;


	public Marchandise create(Marchandise marchandise) {

		return marchandiseRepo.save(marchandise);
	}

	public Marchandise getById(Long id) {
		return marchandiseRepo.findById(id).orElseThrow(MarchandiseException::new);
	}

	public Marchandise update(Marchandise marchandise) {
		Marchandise marchandiseEnBase = getById(marchandise.getId());
		marchandiseEnBase.setNom(marchandise.getNom());
		marchandiseEnBase.setPrix(marchandise.getPrix());
		marchandiseEnBase.setStock(marchandise.getStock());
		marchandiseEnBase.setDescription(marchandise.getDescription());


		return marchandiseRepo.save(marchandiseEnBase);
	}

	public List<Marchandise> getAll() {
		return marchandiseRepo.findAll();
	}

	public void delete(Marchandise marchandise) {
		marchandiseRepo.delete(marchandise);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
}
