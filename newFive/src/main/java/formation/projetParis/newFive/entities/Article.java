package formation.projetParis.newFive.entities;


import java.util.Objects;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name="articles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length =1)
@SequenceGenerator(sequenceName = "seq_article", name = "seqArticle", initialValue = 100, allocationSize = 100)
@NamedQueries({
	@NamedQuery(name = "Article.findByKey", query = "select a from Article a where a.id=:id"),
	@NamedQuery(name = "Article.findByNomContaining", query = "select a from Article a where a.nom like :texte ")})

public class Article {
	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArticle")
	private Long id;
	@JsonView(JsonViews.Base.class)
    private double prix;
	 // @JsonView(JsonViews.LigneDeCommande.class)
    @OneToMany(mappedBy = "id.article")
	private Set<LigneDeCommande> lignes;
    
    public Article() {
    }

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Article other = (Article) obj;
		return Objects.equals(id, other.id);
	}
	
    

}