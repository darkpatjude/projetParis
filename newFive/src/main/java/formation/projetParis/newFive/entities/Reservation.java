package formation.projetParis.newFive.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("R")

public class Reservation extends Article {


	@JsonView(JsonViews.Base.class)
	private LocalDate date;
	@JsonView(JsonViews.Base.class)
	private LocalTime heure;
	@OneToOne
	@JoinColumn(name = "terrain_number") //nom dans la base
	@JsonView(JsonViews.Base.class)
	private Terrain terrainReserve;
	
	
	public Reservation(LocalDate date, LocalTime heure) {

		this.date = date;
		this.heure = heure;
	}

	public Reservation() {
		super();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public Terrain getTerrainReserve() {
		return terrainReserve;
	}

	public void setTerrainReserve(Terrain terrainReserve) {
		this.terrainReserve = terrainReserve;
	}
	
	


}