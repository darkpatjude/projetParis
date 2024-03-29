package formation.projetParis.newFive.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.projetParis.newFive.entities.Admin;
import formation.projetParis.newFive.entities.Utilisateur;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	List<Admin> findByPrenomOrNom(String prenom,String nom);
	
	Optional<Admin> findByEmail(String email);
	Optional<Admin> findByTelephone(String tel);
	
	Optional<Admin> findByLogin(String login);

}
