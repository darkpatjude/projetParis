package formation.projetParis.newFive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.projetParis.newFive.entities.Terrain;
import formation.projetParis.newFive.exceptions.TerrainException;
import formation.projetParis.newFive.repositories.TerrainRepository;

@Service
public class TerrainService {

	@Autowired
	private TerrainRepository terrainRepo;


	public Terrain create(Terrain t) { //exception si no hay cuáles params??

		return terrainRepo.save(t);
	}

	public Terrain getById(Long id) {
		return terrainRepo.findById(id).orElseThrow(TerrainException::new);
	}

	public Terrain update(Terrain t) {
		Terrain terrainEnBase = getById(t.getId());
		terrainEnBase.setNom(t.getNom());
		terrainEnBase.setImageUrl(t.getImageUrl());
		terrainEnBase.setHeureOuverture(t.getHeureOuverture());
		terrainEnBase.setHeureFermeture(t.getHeureFermeture());
		return terrainRepo.save(terrainEnBase);
	}

	public List<Terrain> getAll() {
		return terrainRepo.findAll();
	}

	public void delete(Terrain t) {
		terrainRepo.delete(t);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
}
