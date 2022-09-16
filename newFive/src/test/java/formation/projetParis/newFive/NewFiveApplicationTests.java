package formation.projetParis.newFive;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import formation.projetParis.newFive.entities.Admin;
import formation.projetParis.newFive.entities.Adresse;
import formation.projetParis.newFive.entities.Ballon;
import formation.projetParis.newFive.entities.Client;
import formation.projetParis.newFive.entities.Commande;
import formation.projetParis.newFive.entities.LigneDeCommande;
import formation.projetParis.newFive.entities.Maillot;
import formation.projetParis.newFive.entities.Reservation;
import formation.projetParis.newFive.entities.Terrain;
import formation.projetParis.newFive.services.AdminService;
import formation.projetParis.newFive.services.ClientService;
import formation.projetParis.newFive.services.CommandeService;
import formation.projetParis.newFive.services.MarchandiseService;
import formation.projetParis.newFive.services.ReservationService;
import formation.projetParis.newFive.services.TerrainService;

@SpringBootTest
@Transactional
public class NewFiveApplicationTests {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ReservationService reservService;

	@Autowired
	private TerrainService terrainService;

	@Autowired
	private MarchandiseService merchService;

	@Autowired
	private CommandeService comService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	@Commit
	public void creationClientTest() {
		Client client = new Client();
		client.setPrenom("Julian");
		client.setNom("assad");
		client.setLogin("patjude1");
		client.setPassword(passwordEncoder.encode("Qwerty123@"));
		client.setAdresse(new Adresse("122", "Route de la reine", "92100", "Boulogne"));
		clientService.create(client);
		assertNotNull(clientService.getById(client.getId()));
	}

	@Test
	@Commit
	public void creationGeneral() {

		// Client
		Client client = new Client();
		client.setPrenom("valentin");
		client.setNom("dumas");
		client.setLogin("patjude2");
		client.setPassword(passwordEncoder.encode("Qwerty123@"));
		client.setAdresse(new Adresse("15", "Chez Valentin", "93000", "Ville dans le 93"));
		clientService.create(client);

		// admin
		Admin admin1 = new Admin();
		admin1.setNom("Coulibaly");
		admin1.setPrenom("Mohamed");
		admin1.setLogin("patjude");
		admin1.setPassword(passwordEncoder.encode("Qwerty123@"));
		adminService.create(admin1);
		
		//deuxieme admin
		Admin admin2 = new Admin();
		admin2.setNom("Olivier");
		admin2.setPrenom("Gozlan");
		admin2.setLogin("OLIVE");
		admin2.setPassword(passwordEncoder.encode("Qwerty123@"));
		adminService.create(admin2);

		// merch
		Ballon ballon1 = new Ballon();
		ballon1.setCouleur("rouge");
		ballon1.setNom("ballon d'entrainement 3000");
		ballon1.setDescription("ballon de la coupe du monde Qatar 2022");
		ballon1.setPrix(50);
		ballon1.setStock(33);
		ballon1.setTaille("Enfant");

		Maillot maillot1 = new Maillot();
		maillot1.setNom("Maillot PSG");
		maillot1.setTaille("Medium");
		maillot1.setDescription("Maillot Visite PSG 2022");
		maillot1.setEquipe("PSG");
		maillot1.setPrix(123);
		maillot1.setStock(50);

		merchService.create(maillot1);
		merchService.create(ballon1);

		// terrain
		Terrain terrain1 = new Terrain(); // effacer set id? et ptet d'autres getters setters
		terrain1.setNom("Jaune");
		terrain1.setHeureOuverture(LocalTime.of(23, 0));
		terrain1.setHeureFermeture(LocalTime.of(8, 0));
		terrainService.create(terrain1);

		// reservation
		Reservation reservation1 = new Reservation();
		reservation1.setDate(LocalDate.of(2008, 11, 29));
		reservation1.setHeure(LocalTime.of(15, 30, 57));
		reservation1.setTerrainReserve(terrain1); // probleme 1?
		reservService.create(reservation1);

		// reservation2
		Reservation reservation2 = new Reservation();
		reservation2.setDate(LocalDate.of(2022, 11, 29));
		reservation2.setHeure(LocalTime.of(12, 15, 02));
		reservation2.setTerrainReserve(terrain1);
		reservService.create(reservation2);

		// non terminé
		//commande
		

		Commande commandeClient =new Commande();
		commandeClient.setClient(client);
		commandeClient.setDate(LocalDate.now());
		commandeClient.setPrix(30);
		commandeClient.setClient(client);
		comService.create(commandeClient);

	}
	
	@Test
	@Commit
	public void creationTerrainsTest() {
		Terrain terrain1 = new Terrain(); // effacer set id? et ptet d'autres getters setters
		terrain1.setNom("Bleu");
		terrain1.setHeureOuverture(LocalTime.of(23, 0));
		terrain1.setHeureFermeture(LocalTime.of(8, 0));
		terrainService.create(terrain1);
		
		Terrain terrain2 = new Terrain(); // effacer set id? et ptet d'autres getters setters
		terrain2.setNom("Rouge");
		terrain2.setHeureOuverture(LocalTime.of(23, 0));
		terrain2.setHeureFermeture(LocalTime.of(8, 0));
		terrainService.create(terrain2);
		
		Terrain terrain3 = new Terrain(); // effacer set id? et ptet d'autres getters setters
		terrain3.setNom("Vert");
		terrain3.setHeureOuverture(LocalTime.of(23, 0));
		terrain3.setHeureFermeture(LocalTime.of(8, 0));
		terrainService.create(terrain3);
	}
	
	@Test
	@Commit
	public void creationMarchandise() {
		Ballon ballon1 = new Ballon();
		ballon1.setCouleur("Noir");
		ballon1.setNom("Ballon super max");
		ballon1.setDescription("Ballon très joli");
		ballon1.setPrix(50);
		ballon1.setStock(33);
		ballon1.setTaille("Adulte");

		Maillot maillot1 = new Maillot();
		maillot1.setNom("Maillot Manchester City");
		maillot1.setTaille("Medium");
		maillot1.setDescription("Maillot Visite Manchester City 2022");
		maillot1.setEquipe("Manchester City");
		maillot1.setPrix(150);
		maillot1.setStock(50);

		merchService.create(maillot1);
		merchService.create(ballon1);
	}

}