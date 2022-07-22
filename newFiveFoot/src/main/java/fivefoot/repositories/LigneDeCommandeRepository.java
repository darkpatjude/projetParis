package fivefoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fivefoot.entities.LigneCommandeKey;
import fivefoot.entities.LigneDeCommande;

public interface LigneDeCommandeRepository extends JpaRepository<LigneDeCommande, LigneCommandeKey> {

}
