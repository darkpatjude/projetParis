package fiveFoot;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fivefoot.util.Context;
import fivefoot.entities.Adresse;
import fivefoot.entities.Article;
import fivefoot.entities.Ballon;
import fivefoot.entities.Client;
import fivefoot.entities.Utilisateur;

public class AppTest {

	public static void main(String[] args) {
		//Context.getEntityManagerFactory();
		
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		
		Article b=new Ballon("s", "blanc");
		b.setId(1L);
		b.setPrix(5);
		System.out.println("le prix " +b.getPrix());
		Client client= new Client();
		client.setAdresse(new Adresse("2", "rue,", "00000", "paris"));
		
		
		tx.begin();
		em.persist(b);
		tx.commit();
		em.close();
		
		Context.destroy();
	}

}
