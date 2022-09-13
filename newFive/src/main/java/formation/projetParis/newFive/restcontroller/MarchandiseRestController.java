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

import formation.projetParis.newFive.entities.Ballon;
import formation.projetParis.newFive.entities.JsonViews;
import formation.projetParis.newFive.entities.Maillot;
import formation.projetParis.newFive.entities.Marchandise;
import formation.projetParis.newFive.services.BallonService;
import formation.projetParis.newFive.services.MaillotService;
import formation.projetParis.newFive.services.MarchandiseService;

@RestController
@RequestMapping("/api/marchandise")
@CrossOrigin(origins="*")
public class MarchandiseRestController  {

	@Autowired
	private MarchandiseService marchandiseService;
	
	@Autowired
	private BallonService ballonService;
	
	@Autowired
	private MaillotService maillotService;

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
	@PostMapping("/ballon")
	public Ballon create(@Valid @RequestBody Ballon balle, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return ballonService.create(balle);
	}
	
	@JsonView(JsonViews.Base.class)
	@PostMapping("/maillot")
	public Maillot create(@Valid @RequestBody Maillot produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return maillotService.create(produit);
	}

	@PutMapping("/edit/{id}")
	@JsonView(JsonViews.Base.class)
	public Marchandise update(@PathVariable Long id, @Valid @RequestBody Marchandise produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		produit.setId(id);
		return marchandiseService.update(produit);
	}
	
	@PutMapping("/ballon/edit/{id}")
	@JsonView(JsonViews.Base.class)
	public Marchandise updateBallon(@PathVariable Long id, @Valid @RequestBody Ballon ballon, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		ballon.setId(id);
		return marchandiseService.update(ballon);
	}
	
	@PutMapping("/maillot/edit/{id}")
	@JsonView(JsonViews.Base.class)
	public Marchandise updateMaillot(@PathVariable Long id, @Valid @RequestBody Maillot maillot, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		maillot.setId(id);
		return marchandiseService.update(maillot);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		marchandiseService.deleteById(id);
	}
	
	@GetMapping("/ballon")
	@JsonView(JsonViews.Base.class)
	public List<Ballon> getAllBallons() {
		return ballonService.getAll();
	}
	
	@GetMapping("/ballon/{id}")
	@JsonView(JsonViews.Base.class)
	public Ballon getBallonById(@PathVariable Long id) {
		return ballonService.getById(id);
	}
	
	@GetMapping("/maillot")
	@JsonView(JsonViews.Base.class)
	public List<Maillot> getAllMaillots() {
		return maillotService.getAll();
	}
	
	@GetMapping("/maillot/{id}")
	@JsonView(JsonViews.Base.class)
	public Maillot getMaillotById(@PathVariable Long id) {
		return maillotService.getById(id);
	}
	
	
}
