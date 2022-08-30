package fivefoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fivefoot.entities.Marchandise;

public interface MarchandiseRepository extends JpaRepository<Marchandise, Long>{

}
