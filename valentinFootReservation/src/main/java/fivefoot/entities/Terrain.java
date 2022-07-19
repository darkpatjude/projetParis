package fivefoot.entities;

import java.sql.Time;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="terrains")
@SequenceGenerator(sequenceName = "seq_terrain", name = "seqTerrain", initialValue = 1, allocationSize = 100)

public class Terrain {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTerrain")
	@Id
	private Long id_terrain;
    private String nom;
    private Time heureFermeture;
    private Time heureOuverture;
    
    public Terrain() {
    }

	public Terrain(String nom, Long id_terrain, Time heureFermeture, Time heureOuverture) {
		super();
		this.nom = nom;
		this.id_terrain = id_terrain;
		this.heureFermeture = heureFermeture;
		this.heureOuverture = heureOuverture;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId_terrain() {
		return id_terrain;
	}

	public void setId_terrain(Long id_terrain) {
		this.id_terrain = id_terrain;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_terrain);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terrain other = (Terrain) obj;
		return Objects.equals(id_terrain, other.id_terrain);
	}
    
	
    
    

}