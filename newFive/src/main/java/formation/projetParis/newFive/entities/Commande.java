package formation.projetParis.newFive.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
@Entity
@Table(name = "commandes")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 100, allocationSize = 1)


public class Commande {

	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
    private Long id;
	@JsonView(JsonViews.Base.class)
    private LocalDate date;
	@JsonView(JsonViews.Base.class)
    private double prix;
	@JsonView(JsonViews.Commande.class)
    @ManyToOne
	@JoinColumn(name = "commande_id_client", foreignKey = @ForeignKey(name = "commande_commande_id_client_fk"))
    private Client client;
	@JsonView(JsonViews.CommandeDetails.class)
    @OneToMany(mappedBy = "id.commande")
    private Set<LigneDeCommande> lignes;
    
    public Commande() {
    }

	public Commande(Long id_commande, LocalDate date, double prix, Set<LigneDeCommande> lignes) {
		super();
		this.id = id_commande;
		this.date = date;
		this.prix = prix;
		this.lignes = lignes;
	}

	public Long getId() {
		return id;
	}

	public Commande(Client client) {
		this.client = client;
		this.date = LocalDate.now();
	}
	
	public void setId(Long id_commande) {
		this.id = id_commande;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Set<LigneDeCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Set<LigneDeCommande> lignes) {
		this.lignes = lignes;
	}
	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		Commande other = (Commande) obj;
		return Objects.equals(id, other.id);
	}
    
	


    


}