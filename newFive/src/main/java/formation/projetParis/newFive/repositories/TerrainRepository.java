package formation.projetParis.newFive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import formation.projetParis.newFive.entities.Client;
import formation.projetParis.newFive.entities.Commande;

public interface TerrainRepository extends JpaRepository<Commande, Long> {
	@Transactional
	@Modifying
	@Query("update Commande c set c.client=null where c.client=:client")
	void setClientToNullByClient(@Param("client") Client client);
}
