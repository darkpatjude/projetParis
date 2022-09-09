package formation.projetParis.newFive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.projetParis.newFive.entities.LigneCommandeKey;
import formation.projetParis.newFive.entities.LigneDeCommande;

public interface LigneDeCommandeRepository extends JpaRepository<LigneDeCommande, LigneCommandeKey> {

//	List<LigneDeCommande> findByCommandes(Commande commande);
//
//	@Transactional
//	@Modifying
//	@Query("select c from Commande c left join fetch c.client where c.client.id_client=:idclient")
//	List<Commande> findByIdClient(@Param("idclient") Long id);






}
