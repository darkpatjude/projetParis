package fivefoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fivefoot.entities.Admin;
import fivefoot.entities.Client;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	List<Admin> findByPrenomOrNom(String prenom,String nom);
	
	Optional<Admin> findByEmail(String email);
	Optional<Admin> findByTelephone(String tel);

}
