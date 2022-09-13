package magasin;

public class Magasin implements ObjectAvecDescription,Rendement{
	private double depense = 0;
	private double revenus = 0;
	private Article[][] produits = {
			{ new Electromenager(100, 200, "frigo", "darty"), new Electromenager(50, 200, "grille pain", "amazon") },
			{ new Primeur(0.1, 1, "pomme", "le mec du coin"), new Primeur(0.2, 0.3, "poire", "quelquun") } };
//	private Article[][] produits;

	public Magasin() {
		remplirStock();
//		produits = new Article[2][];
//		produits[0] = new Electromenager[2];
//		produits[1] = new Primeur[2];
	}

	public String description() {
		String etat = "articles electromenager\n";
		for (int i = 0; i < produits[0].length; i++) {
			etat = etat + produits[0][i].description() + "\n";
		}
		etat = etat + "articles primeur\n";
		for (Article article : produits[1]) {
			etat = etat + article.description() + "\n";
		}
		return etat;
	}

	public void remplirStockElectromanager(int quantite) {
		for (Article article : produits[0]) {
			((Electromenager) article).remplirStock(quantite);
			depense += article.getPrixAchat() * quantite;
		}
	}

	public void remplirStockPrimeur(double quantite) {
		for (Article article : produits[1]) {
			((Primeur) article).remplirStock(quantite);
			depense += article.getPrixAchat() * quantite;
		}
	}

	public void remplirStock() {
		remplirStockElectromanager(10);
		remplirStockPrimeur(50);
	}

	public void vendreArticleElectromenager(int indice, int quantite) {
		revenus += ((VendableParPiece) produits[0][indice]).vendre(quantite);
	}

	public void vendreArticlePrimeur(int indice, double quantite) {
		revenus += ((VendableAuKilo) produits[1][indice]).vendre(quantite);
	}

	public double rendement() {
		return (revenus - depense) / depense;
	}
}
