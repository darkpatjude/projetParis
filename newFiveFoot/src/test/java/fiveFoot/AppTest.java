package fiveFoot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import fivefoot.util.Context;
import fivefoot.entities.Adresse;
import fivefoot.entities.Article;
import fivefoot.entities.Ballon;
import fivefoot.entities.Client;
import fivefoot.entities.Marchandise;
import fivefoot.entities.Utilisateur;

public class AppTest {

	public static void main(String[] args) {
		//Context.getEntityManagerFactory();
		
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		
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
		
		
		tx.begin();
		em.persist(b);
		em.persist(b2);		
		em.persist(b3);
		tx.commit();
		//em.close();
		
		TypedQuery<Article> query = em.createNamedQuery("Article.findByNomContaining", Article.class);
		query.setParameter("texte", "%" + "b" + "%");
		List<Article> list = query.getResultList();
		em.close();
		System.out.println("--------------------------------");
		
		
		for ( int i=1; i<3; i++) {
			System.out.println(" --> " +list.size());//+list.get(i).getPrix());
			
		}

		System.out.println("--------------------------------");
		Context.destroy();
		
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
