package formation.projetParis.newFive.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.projetParis.newFive.entities.Client;
import formation.projetParis.newFive.entities.Commande;
import formation.projetParis.newFive.entities.JsonViews;
import formation.projetParis.newFive.models.CommandeRestModel;
import formation.projetParis.newFive.services.ClientService;
import formation.projetParis.newFive.services.CommandeService;

@RestController
@RequestMapping("/api/commande")
@CrossOrigin(origins="*")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientService;

//	@PostMapping("")
//	public Commande create(Client client, Map<Produit, Integer> panier) {
//		return commandeService.create(panier, client);
//	}

	
		//pas necessaire?
	  @GetMapping("")
	    @JsonView(JsonViews.Base.class)
	    public List<Commande> getAll() {
	        return commandeService.getAll();
	    }
	
	
	@PostMapping("")
	@JsonView(JsonViews.Commande.class)
	public Commande create(@RequestBody CommandeRestModel commande) {
		return commandeService.create(
				commande.getPanier().stream().collect(Collectors.toMap(e -> e.getArticle(), e -> e.getQuantite())),
				commande.getClient());
	}

	@PostMapping("/commande")
	@JsonView(JsonViews.Commande.class)
	public Commande create(@RequestBody Commande commande) {
		return commandeService.create(commande);
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.CommandeDetails.class)
	public Commande getById(@PathVariable Long id) {
		return commandeService.getById(id);
	}
}
