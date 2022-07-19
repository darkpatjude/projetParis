package fivefoot.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

public class Reservation extends Article {
	
	 private Long id_reservation;
	 private LocalDate date;
	 private Time heure;
	 
	public Reservation(Long id_reservation, LocalDate date, Time heure) {
		super();
		this.id_reservation = id_reservation;
		this.date = date;
		this.heure = heure;
	}
	public Reservation() {
		super();
	}
	public Long getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(Long id_reservation) {
		this.id_reservation = id_reservation;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(id_reservation);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(id_reservation, other.id_reservation);
	}
	
	

	 
}