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
import formation.projetParis.newFive.entities.Reservation;
import formation.projetParis.newFive.services.ReservationService;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins="*")
public class ReservationRestController {

	
	@Autowired
	private ReservationService reservationService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Reservation getById(@PathVariable Long id) {
		return reservationService.getById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}

	@JsonView(JsonViews.Base.class)
	@PostMapping("")
	public Reservation create(@Valid @RequestBody Reservation produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return reservationService.create(produit);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Reservation update(@PathVariable Long id, @Valid @RequestBody Reservation produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		produit.setId(id);
		return reservationService.update(produit);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		reservationService.deleteById(id);
	}
}
