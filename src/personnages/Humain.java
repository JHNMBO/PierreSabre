package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissances=0;
	protected int nbConnaissancesBis=0;
	protected Humain[] memoire;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + getNom() + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + getNom() + " et j'aime boire du " + boissonFavorite + ".");
	}
	
	public void boire(String boisson) {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		int argentEnPoche = getArgent();
		if(argentEnPoche >= prix) {
			parler("J'ai " + argentEnPoche + " sous en poche. Je vais pouvoir m'offrir " + bien +" à " + prix + " sous");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que " + argentEnPoche + " sous en poche. Je ne peux même pas m'offrir un kimono à " + prix + " sous");
		}
	}
	
	protected void gagnerArgent(int gain) {
		argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		argent -= perte;
	}
		
	public void faireConnaissanceAvec(Humain homme2) {
		direBonjour();
		homme2.repondre(this);
		memoriser(homme2);
	}
	
	private void repondre(Humain homme1) {
		direBonjour();
		memoriser(homme1);
	}
	
	private void memoriser(Humain humain) {
		if(nbConnaissances<30) {
			memoire[nbConnaissances] = humain;
			nbConnaissances += 1;
		}
		else {
			nbConnaissancesBis=30;
			nbConnaissances=1;
			
		}
	}
	
	public void listerConnaissance() {
		parler("Je connais beaucoup de monde dont : ");
		for(int i=0;i<nbConnaissances;i++) {
			System.out.println(memoire[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire("kombucha");
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
	}
}
