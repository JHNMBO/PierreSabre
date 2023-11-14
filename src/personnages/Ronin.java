package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom,boissonFavorite,argent);
	}
	
	public int getHonneur() {
		return honneur;
	}
	
	public void donner(Commercant beneficiaire) {
		int argent = getArgent();
		int argentDonne = argent/10;
		parler(beneficiaire.getNom() + " prends ces " + argentDonne + " sous.");
	}
}
