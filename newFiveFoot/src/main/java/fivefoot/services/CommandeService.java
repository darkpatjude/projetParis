package fivefoot.services;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import fivefoot.Exception.CommandeException;
import fivefoot.entities.Article;
import fivefoot.entities.Client;
import fivefoot.entities.Commande;
import fivefoot.entities.LigneCommandeKey;
import fivefoot.entities.LigneDeCommande;
import fivefoot.repositories.CommandeRepository;
import fivefoot.repositories.LigneDeCommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepo;
	@Autowired
	private LigneDeCommandeRepository lCRepo;
	@Autowired
	private ClientService clientService;

	public Commande create(Commande commande) {
		if (commande.getDate() == null) {
			commande.setDate(LocalDate.now());
		}
		commandeRepo.save(commande);
		commande.getLignes().forEach(ligne -> {
			ligne.getId().setCommande(commande);
		});
		lCRepo.saveAll(commande.getLignes());
		return commande;
	}

	public Commande create(Map<Article, Integer> panier, Client client) {
		Client clientBase = clientService.getById(client.getId_client());
		Commande commande = new Commande(clientBase);
		commandeRepo.save(commande);
		panier.forEach((k, v) -> {
			lCRepo.save(new LigneDeCommande(new LigneCommandeKey(commande, k), v));
		});
		return commande;
	}

	public Commande getById(Long id) {
		return commandeRepo.findByIdWithLignes(id).orElseThrow(CommandeException::new);
	}
}
