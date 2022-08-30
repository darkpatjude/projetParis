package fivefoot.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fivefoot.entities.Adresse;
import fivefoot.entities.Client;
import fivefoot.entities.Commande;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	List<Client> findByPrenomOrNom(String prenom,String nom);
	
	Optional<Client> findByEmail(String email);
	Optional<Client> findByTelephone(String tel);

	
	Optional<Client> findByKeyWithCommandes(@Param("id") Long id_client);
	Optional<Client> findByIdWithCommandesDetails(@Param("id") Long id_client);
	
}



		