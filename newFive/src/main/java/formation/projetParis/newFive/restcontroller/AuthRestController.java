package formation.projetParis.newFive.restcontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.projetParis.newFive.entities.Client;
import formation.projetParis.newFive.entities.JsonViews;
import formation.projetParis.newFive.entities.Utilisateur;
import formation.projetParis.newFive.repositories.ClientRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {
	
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final static Logger LOGGER=LoggerFactory.getLogger(AuthRestController.class);
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class) // esto es para no mostrar la contraseña y solo mostrar lo que queremos (wtf) se pone tanto aqui como en el controller
	public Utilisateur auth(@AuthenticationPrincipal Utilisateur utilisateur) {
		LOGGER.info(utilisateur.getLogin());
		return utilisateur;
	}
	
	@PostMapping("/inscription")
	@JsonView(JsonViews.Base.class)
	public Client inscription(@Valid @RequestBody Client client, BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		client.setPassword((passwordEncoder.encode(client.getRealpassword())));
		client.setRole("ROLE_USER");
		return clientRepo.save(client);
	}

}
