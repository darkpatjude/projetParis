package magasin;

public class Electromenager extends Article implements VendableParPiece, Solde {
	private int stock = 0;

	public Electromenager(double prixAchat, double prixVente, String nom, String fournisseur) {
		super(prixAchat, prixVente, nom, fournisseur);
	}

	public void remplirStock(int quantite) {
		stock += quantite;
	}

	@Override
	public void lancerSolde(double pourcentage) {
		setPrixVente(getPrixVente() - getPrixVente() * pourcentage / 100);

	}

	@Override
	public void terminerSolde(double pourcentage) {
		setPrixVente(getPrixVente() + getPrixVente() * pourcentage / 100);
	}

	@Override
	public double vendre(int quantite) {
		stock -= quantite;
		return getPrixVente() * quantite;
	}

	@Override
	public String description() {
		return super.description() + ", stock:" + stock;
	}

}
