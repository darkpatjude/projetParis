package formation.projetParis.newFive.entities;

import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="terrains")
@SequenceGenerator(sequenceName = "seq_terrain", name = "seqTerrain", initialValue = 1, allocationSize = 1)

public class Terrain {
	@JsonView(JsonViews.Base.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTerrain")
	@Id
	private Long id;
	@JsonView(JsonViews.Base.class)
    private String nom;
	@JsonView(JsonViews.Base.class)
    private LocalTime heureFermeture;
	@JsonView(JsonViews.Base.class)
    private LocalTime heureOuverture;
	//@JsonView(JsonViews.Base.class) //Infinite loop? :(
   //@OneToOne(mappedBy = "terrainReserve") //nom dans table reservation
	@ManyToOne
    private Reservation reservation;
    
    public Terrain() {
    }

	public Terrain(String nom, Long id_terrain, LocalTime heureFermeture, LocalTime heureOuverture) {
		super();
		this.nom = nom;
		this.id = id_terrain;
		this.heureFermeture = heureFermeture;
		this.heureOuverture = heureOuverture;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id_terrain) {
		this.id = id_terrain;
	}
	
	

	public LocalTime getHeureFermeture() {
		return heureFermeture;
	}

	public void setHeureFermeture(LocalTime heureFermeture) {
		this.heureFermeture = heureFermeture;
	}

	public LocalTime getHeureOuverture() {
		return heureOuverture;
	}

	public void setHeureOuverture(LocalTime heureOuverture) {
		this.heureOuverture = heureOuverture;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
    
	
    
    

}