package fivefoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fivefoot.entities.Commande;
import fivefoot.entities.LigneCommandeKey;
import fivefoot.entities.LigneDeCommande;

public interface LigneDeCommandeRepository extends JpaRepository<LigneDeCommande, LigneCommandeKey> {

	//List<LigneDeCommande> findByCommandes(Commande commande);

//	@Transactional
//	@Modifying
//	@Query("select c from Commande c left join fetch c.client where c.client.id_client=:idclient")
//	List<Commande> findByIdClient(@Param("idclient") Long id);
//
//	@Transactional
//	@Modifying
//	@Query("update Commande c set c.client=null where c.client=:client")
//	void setClientToNullByClient(@Param("client") Client client);

	// afficher les commandes pour un client****************
	// afficher les reservations d'une journée/semaine - d'une date 1 à une date 2;
	// par l'admin
	// afficher marchandises et leurs stocks par admin/Client
	// mettre a jour le stock par admin / apres achat
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
