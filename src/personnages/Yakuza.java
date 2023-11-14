package personnages;

public class Yakuza extends Humain {
	private String clan;
	int reputation;
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
		this.reputation = 0;
	}
	
	public String getClan() {
		return clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorque = victime.seFaireExtorquer();
		parler("J'ai piqué les " + argentExtorque + " sous de Marco, ce ui me fait " + getArgent() + " sous dans ma poche. Hi! Hi!");
	}
}
