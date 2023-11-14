package personnages;

public class Yakuza extends Humain {
	private String clan;
	int reputation = 0;
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}
	
	public String getClan() {
		return clan;
	}
	
	public int getReputation() {
		return reputation;
	}
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorque = victime.seFaireExtorquer();
		gagnerArgent(argentExtorque); 
		parler("J'ai piqué les " + argentExtorque + " sous de Marco, ce qui me fait " + getArgent() + " sous dans ma poche. Hi! Hi!");
		reputation += 1;
	}
	
	public int perdre() {
		int argentInit = getArgent();
		perdreArgent(argentInit);
		if(reputation < 0) {
			reputation -= 1;
		}
		parler("J'ai perdu mon duel et mes " + argentInit + " sous, snif... J'ai déshonoré le clan de " + getClan());
		return argentInit;
	}
	
	public void gagner(int gain) {
		 gagnerArgent(gain);
		 reputation += 1;
		 parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + getClan() + " ?\nJe l'ai dépouillé de ses " + gain + " sous.");
	}
}
