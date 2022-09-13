package magasin;

public class Article implements ObjectAvecDescription, Rendement {
	private double prixAchat;
	private double prixVente;
	private String nom;
	private String fournisseur;

	public Article(double prixAchat, double prixVente, String nom, String fournisseur) {
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.nom = nom;
		this.fournisseur = fournisseur;
	}

	public String description() {
		return "nom:" + nom + ", fournisseur:" + fournisseur + ", rendement:" + prixAchat + ", prix vente:" + prixVente
				+ ", rendement:" + rendement();
	}

	public double rendement() {
		return ((prixVente - prixAchat) / prixAchat) * 100;
	}

	protected void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public double getPrixAchat() {
		return prixAchat;
	}
}
