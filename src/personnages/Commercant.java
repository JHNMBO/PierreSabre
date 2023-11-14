package personnages;

public class Commercant extends Humain{
	private String nom;
	private String boissonFavorite;
	private int argent;
	
	public Commercant(String nom, int argent) {
		super(nom,"thé",argent);
	}
		
	public int seFaireExtorquer() {
		int argentExtorque = getArgent();
		perdreArgent(argentExtorque);
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return argentExtorque;
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous ! Je te remercie généreux donateur!");
	}
}
