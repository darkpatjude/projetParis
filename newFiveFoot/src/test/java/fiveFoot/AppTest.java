package fiveFoot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fivefoot.config.AppConfig;
import fivefoot.entities.Adresse;
import fivefoot.entities.Article;
import fivefoot.entities.Ballon;
import fivefoot.entities.Client;
import fivefoot.entities.Commande;
import fivefoot.entities.LigneDeCommande;
import fivefoot.repositories.ArticleRepository;
import fivefoot.repositories.ClientRepository;
import fivefoot.repositories.CommandeRepository;
import fivefoot.repositories.LigneDeCommandeRepository;

public class AppTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ArticleRepository articleRepo = ctx.getBean(ArticleRepository.class);
		ClientRepository clientRepo = ctx.getBean(ClientRepository.class);
		CommandeRepository commRepo = ctx.getBean(CommandeRepository.class);
		LigneDeCommandeRepository ldcRepo = ctx.getBean(LigneDeCommandeRepository.class);
		
		
		Ballon b=new Ballon();
		//b.setId(1L);
		
		//b = articleRepo.save(b);
		
		b.setPrix(5);
		b.setCouleur("pink");
		b.setDescription("ballon rond");
		b = articleRepo.save(b);
		
		Client olive=new Client();
		olive.setPrenom("olivier");
		olive.setNom("gozlan");
		olive.setEmail("mohamedlebg@gmail.com");
		olive.setTelephone("0776344097");
		clientRepo.save(olive);
		
		//clientRepo.delete(olive);
		System.out.println(clientRepo.findByEmail("mohamedlebg@gmail.com"));
		System.out.println(olive);

		
		//clientRepo.deleteById(1L);
		//clientRepo.delete(olive);
		
		//cretaion de commande
		Commande commande1=new Commande();
		commande1.setPrix(987);
		commande1.setClient(olive);
		commRepo.save(commande1);
		
		Commande commande2=new Commande();
		commande2.setPrix(4500);
		commande2.setClient(olive);
		commRepo.save(commande2);
		
		System.out.println(commRepo.findByIdClient(1L));
		
		System.out.println(commRepo.findById(100L));
		
		LigneDeCommande ldc=new LigneDeCommande();
		//ldc.setId(null);
		//ldcRepo.save(ldc);
		
		
		
		Article b2=new Ballon();
		//b.setId(1L);
		b2.setPrix(8);
		Article b3=new Ballon();
		//b.setId(1L);;
		b3.setPrix(51);
		System.out.println("le prix " +b.getPrix());
		Client client= new Client();
		client.setAdresse(new Adresse("2", "rue,", "00000", "paris"));
		


		System.out.println("--------------------------------");
		


		System.out.println("--------------------------------");
		
		ctx.close();

		
		//afficher les commandes pour un client
		// afficher les reservations d'une journée/semaine - d'une date 1 à une date 2; par l'admin
		// afficher marchandises et leurs stocks par admin/Client
		//mettre a jour le stock par admin / apres achat
		// modifier reservation par le client
		// modifier compte par client
		// supprimer compte par client
		// supprimer compte par admin
		// afficher commande client par client
		// afficher ligne de commande par 
		// ajouter une ligne de commande
		// modifier ligne de commande
		// supprimer ligne de commande
		// annuler commande
		// modifier commandes
		// modifier identifiant / mot de passe

	}

}
