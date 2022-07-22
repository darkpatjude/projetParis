package fivefoot.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Table(name="reservations")
//@SequenceGenerator(sequenceName = "seq_reservation", name = "seqArticle", initialValue = 1, allocationSize = 100)
@DiscriminatorValue("R")

public class Reservation extends Article {
	
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
//	@Id
//	 private Long id_reservation;
	 private LocalDate date;
	 private Time heure;
		@OneToOne
		@JoinColumn(name = "terrain_id")
	 private Terrain terrainReserve;
	public Reservation( LocalDate date, Time heure) {

		this.date = date;
		this.heure = heure;
	}
	public Reservation() {
		super();
	}
//	public Long getId_reservation() {
//		return id_reservation;
//	}
//	public void setId_reservation(Long id_reservation) {
//		this.id_reservation = id_reservation;
//	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Time getHeure() {
		return heure;
	}
	public void setHeure(Time heure) {
		this.heure = heure;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(id_reservation);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Reservation other = (Reservation) obj;
//		return Objects.equals(id_reservation, other.id_reservation);
//	}
	
	

	 
}