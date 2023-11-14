package personnages;

public class Ronin extends Humain {
	private int honneur = 0;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom,boissonFavorite,argent);
	}
	
	public int getHonneur() {
		return honneur;
	}
	
	public void donner(Commercant beneficiaire) {
		int argent = getArgent();
		int argentDonne = argent/10;
		perdreArgent(argentDonne);
		parler(beneficiaire.getNom() + " prends ces " + argentDonne + " sous.");
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = honneur*2;
		if(force>=adversaire.getReputation()) {
			honneur += 1;
			parler("Je t'ai eu petit yakuza!");
			adversaire.perdre();
		}
		else {
			honneur -= 1;
			int argentInit = getArgent();
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argentInit);
			perdreArgent(argentInit);
		}
	}
	
	
}
