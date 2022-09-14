package formation.projetParis.newFive.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

//@MappedSuperclass
@Entity
public abstract class Marchandise extends Article {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMarchandise")
//    private Long id_marchandise;
	@JsonView(JsonViews.Base.class)
	private String nom;
	@JsonView(JsonViews.Base.class)
	private int stock;
	@JsonView(JsonViews.Base.class)

	private String description;
	@JsonView(JsonViews.Base.class)
	private String imageUrl;

	public Marchandise() {
	}

	public Marchandise(String nom, int stock, String description) {
		super();
		// this.id_marchandise = id_marchandise;
		this.nom = nom;
		this.stock = stock;
		this.description = description;
	}

//	public Long getId_marchandise() {
//		return id_marchandise;
//	}
//
//	public void setId_marchandise(Long id_marchandise) {
//		this.id_marchandise = id_marchandise;
//	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id_marchandise);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Marchandise other = (Marchandise) obj;
//		return Objects.equals(id_marchandise, other.id_marchandise);
//	}

}