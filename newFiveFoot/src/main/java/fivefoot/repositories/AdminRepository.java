package fivefoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import fivefoot.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	List<Admin> findByPrenom(String prenom);
	List<Admin> findByPrenomContaining(String prenom);
	List<Admin> findByPrenomOrNom(String prenom,String nom);
	List<Admin> findByPrenomContainingOrNomContaining(String prenom,String nom);
	
//	@Transactional
//	@Modifying
//	@Query("delete from Admin c where c.adresse=:adresse")
//	void deleteByAdresse(@Param("adresse") Adresse adresse);
	
}
