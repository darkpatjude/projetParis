package formationJpaJulian.entities;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "person") // esto asocia con la tabla base de datos que se llama personne
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_person", allocationSize = 1, initialValue = 100)
//(nombre en java, nombre en la base de datos, de cuánto en cuánto va,valor inicial)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //se pueden elegir las tres estrategias de trabajar con tablas, por ahora usamos la de una tabla con un chingo de columnas
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING,length=1) //tendremos una nueva columna que nos dirá que es. Solo existe en la DB y no en Java
public abstract class Personne { //se volvera abstracta

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqPersonne")
	private Long id;
	@Column(name = "first_name", nullable = false)
	private String prenom; // nullable= false es creacion de contraite de type not nulle
	@Column(name = "last_name")
	private String nom;
//	@Column(name="civility",length=4) //solo necesitamos 4 caracteres
//	@Enumerated(EnumType.STRING)
	//otra manera de hacerlo:
	@Column(name="civility")
	@Enumerated(EnumType.ORDINAL) //en vez de poner la letra, pone el número del enum ej: MMLE=2
	private Civilite civilite;
	
	//@Transient //dice que ignoremos Adresse y no lo toma en cuenta
	@Embedded //esta es la solución
	
	@AttributeOverrides({
		@AttributeOverride(name="numero",column= @Column(name="person_number",length=50)), //el primer nombre debe corresponder a los nombres de las variables
		@AttributeOverride(name="rue",column= @Column(name="person_street",length=200)),
		@AttributeOverride(name="codePostal",column= @Column(name="person_zip_code",length=300)),
		@AttributeOverride(name="ville",column= @Column(name="city",length=300))
	})
	private Adresse adresse; //jpa no sabe que hacer con tipos creados por nosotros

	public Personne() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	// dos personas son iguales en este caso si tienen el mismo id
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}

}
