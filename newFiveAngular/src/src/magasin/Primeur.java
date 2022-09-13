package magasin;

public class Primeur extends Article implements VendableAuKilo {
	private double stock = 0;

	public Primeur(double prixAchat, double prixVente, String nom, String fournisseur) {
		super(prixAchat, prixVente, nom, fournisseur);
	}

	@Override
	public double vendre(double quantite) {
		stock -= quantite;
		return getPrixVente() * quantite;
	}

	void remplirStock(double quantite) {
		stock += quantite;
	}

	@Override
	public String description() {
		return super.description() + ", stock:" + stock;
	}
	
}
