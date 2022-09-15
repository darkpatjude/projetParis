package formation.projetParis.newFive.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import formation.projetParis.newFive.entities.Admin;
import formation.projetParis.newFive.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	List<Client> findByPrenomOrNom(String prenom,String nom);
	
	Optional<Client> findByEmail(String email);
	Optional<Client> findByTelephone(String tel);

	
	Optional<Client> findByKeyWithCommandes(@Param("id") Long id);
	Optional<Client> findByIdWithCommandesDetails(@Param("id") Long id);
	
	
	Optional<Client> findByLogin(String login);
}



		