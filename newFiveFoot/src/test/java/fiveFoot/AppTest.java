package fiveFoot;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fivefoot.config.AppConfig;
import fivefoot.entities.Adresse;
import fivefoot.entities.Article;
import fivefoot.entities.Ballon;
import fivefoot.entities.Client;
import fivefoot.repositories.ClientRepository;

public class AppTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ClientRepository clientRepo = ctx.getBean(ClientRepository.class);
		
		Article b=new Ballon();
		//b.setId(1L);
		b.setPrix(5);

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
