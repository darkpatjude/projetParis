package formation.projetParis.newFive.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.projetParis.newFive.entities.JsonViews;
import formation.projetParis.newFive.entities.Utilisateur;

@RestController
@RequestMapping("/api/userinfo")
@CrossOrigin(origins = "*")
public class AuthRestController {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(AuthRestController.class);
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class) // esto es para no mostrar la contraseña y solo mostrar lo que queremos (wtf) se pone tanto aqui como en el controller
	public Utilisateur auth(@AuthenticationPrincipal Utilisateur utilisateur) {
		LOGGER.info(utilisateur.getLogin());
		return utilisateur;
	}

}
