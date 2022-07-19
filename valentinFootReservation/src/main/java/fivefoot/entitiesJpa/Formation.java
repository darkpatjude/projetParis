package formationJpaJulian.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="formotion")
@SequenceGenerator(name="seqFormation",sequenceName="seq_formation",allocationSize = 1,initialValue = 100)

public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	@Column(name = "i_d", nullable = false)
	private Long id;
	@Column(name = "nom_formation", nullable = false)
	private String nom;
	@Column(name = "date_formation", nullable = false)
	private LocalDate dateFormation;
	
	public Formation() { //JPA necesita un constructor sin parametros
		//otros constructores serán para mí
		
	}
	
	
	// constructores extras
	public Formation(String nom, LocalDate dateFormation) {
		this.nom = nom;
		this.dateFormation = dateFormation;
	}
	public Formation(String nom) {
		this(nom,LocalDate.now());
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(LocalDate dateFormation) {
		this.dateFormation = dateFormation;
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
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}

	
	

}
