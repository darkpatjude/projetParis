package formation.projetParis.newFive.restcontroller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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
import formation.projetParis.newFive.entities.Marchandise;
import formation.projetParis.newFive.services.MarchandiseService;

@RestController
@RequestMapping("/api/marchandise")
public class MarchandiseRestController  {

	@Autowired
	private MarchandiseService marchandiseService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Marchandise getById(@PathVariable Long id) {
		return marchandiseService.getById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Marchandise> getAll() {
		return marchandiseService.getAll();
	}

	@JsonView(JsonViews.Base.class)
	@PostMapping("")
	public Marchandise create(@Valid @RequestBody Marchandise produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return marchandiseService.create(produit);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Marchandise update(@PathVariable Long id, @Valid @RequestBody Marchandise produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		produit.setId(id);
		return marchandiseService.update(produit);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		marchandiseService.deleteById(id);
	}
	
	
}
