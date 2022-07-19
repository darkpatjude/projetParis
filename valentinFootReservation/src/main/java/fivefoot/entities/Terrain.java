package fivefoot.entities;

import java.sql.Time;
import java.util.*;

public class Terrain {



    private String nom;
    private Long id_terrain;
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