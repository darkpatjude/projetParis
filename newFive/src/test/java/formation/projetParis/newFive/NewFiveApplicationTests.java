package formation.projetParis.newFive;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import formation.projetParis.newFive.entities.Admin;
import formation.projetParis.newFive.entities.Adresse;
import formation.projetParis.newFive.entities.Client;
import formation.projetParis.newFive.services.AdminService;
import formation.projetParis.newFive.services.ClientService;

@SpringBootTest
@Transactional
public class NewFiveApplicationTests {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AdminService adminService;


	@Test
	@Commit
	public void creationClientTest() {
		Client client = new Client();
		client.setPrenom("Julian");
		client.setNom("assad");
		client.setAdresse(new Adresse("122","Route de la reine", "92100", "Boulogne"));
		clientService.create(client);
		assertNotNull(clientService.getById(client.getId()));
	}
	
	@Test
	@Commit
	public void creationClientTest2() {
		Client client = new Client();
		client.setPrenom("valentin");
		client.setNom("dumas");
		client.setAdresse(new Adresse("123","Route de la reine", "92100", "Boulogne"));
		clientService.create(client);
		assertNotNull(clientService.getById(client.getId()));
		
		Admin admin1=new Admin();
		admin1.setNom("Calentin");
		admin1.setPrenom("Dumex");
		adminService.create(admin1);
	}



}