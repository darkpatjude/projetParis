package formation.projetParis.newFive;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import formation.projetParis.newFive.entities.Adresse;
import formation.projetParis.newFive.entities.Client;
import formation.projetParis.newFive.services.ClientService;

@SpringBootTest
@Transactional
public class NewFiveApplicationTests {

	@Autowired
	private ClientService clientService;


	@Test
	@Commit
	public void creationClientTest() {
		Client client = new Client();
		client.setPrenom("Julian");
		client.setNom("gutierrez");
		client.setAdresse(new Adresse("122","Route de la reine", "92100", "Boulogne"));
		clientService.create(client);
		assertNotNull(clientService.getById(client.getId_client()));
	}



}