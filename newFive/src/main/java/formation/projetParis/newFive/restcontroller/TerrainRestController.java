package formation.projetParis.newFive.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.projetParis.newFive.entities.JsonViews;
import formation.projetParis.newFive.entities.Terrain;
import formation.projetParis.newFive.services.TerrainService;

@RestController
@RequestMapping("/api/terrain")
@CrossOrigin(origins="*")
public class TerrainRestController {

	
	@Autowired
	private TerrainService terrainService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Terrain getById(@PathVariable Long id) {
		return terrainService.getById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Terrain> getAll() {
		return terrainService.getAll();
	}

	@JsonView(JsonViews.Base.class)
	@PostMapping("")
	public Terrain create(@Valid @RequestBody Terrain terrain, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return terrainService.create(terrain);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Terrain update(@PathVariable Long id, @Valid @RequestBody Terrain terrain, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		terrain.setId(id);
		return terrainService.update(terrain);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		terrainService.deleteById(id);
	}
}
