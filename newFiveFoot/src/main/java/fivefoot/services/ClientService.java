package fivefoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fivefoot.Exception.ClientException;
import fivefoot.entities.Client;
import fivefoot.repositories.ClientRepository;
import fivefoot.repositories.CommandeRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private CommandeRepository commandeRepo;
	
	public Client create(Client client) {
		if (client.getPrenom()==null||client.getPrenom().isEmpty()) {
			throw new ClientException();
		}
		if (client.getNom()==null||client.getNom().isEmpty()) {
			throw new ClientException();
		}
		return clientRepo.save(client);
	}

	public Client create(String prenom, String nom) {
		Client client=new Client();
		client.setPrenom(prenom);
		client.setNom(nom);
		return create(client);
	}

	public Client getById(Long id) {
		return clientRepo.findById(id).orElseThrow(ClientException::new); //ecriture pour declarer une exception sans parametres
		
	}
	
//	public Client getByIdWithCommandes(Long id) {
//		return clientRepo.findByKeyWithCommandes(id).orElseThrow(()->{
//			throw new ClientException();
//		}); //escritura clasica para una exception sin parametros... más facil es la de arriba
//	}

	public Client update(Client client) {
		Client clientEnBase= getById(client.getId_client());
		clientEnBase.setPrenom(client.getPrenom());
		clientEnBase.setNom(client.getNom());
		clientEnBase.setAdresse(client.getAdresse());
		return clientRepo.save(clientEnBase);
	}
	
	public List<Client>getAll(){
		return clientRepo.findAll();
	}
	
	public void delete(Client client) {
		commandeRepo.setClientToNullByClient(client);
		clientRepo.delete(client);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}

}
