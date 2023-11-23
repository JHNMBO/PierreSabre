package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissances=0;
	protected int nbConnaissancesMax=30;
	protected boolean memoirePleine=false;
	protected Humain[] memoire;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
		memoire = new Humain[nbConnaissancesMax];
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
		if(nbConnaissances>=nbConnaissancesMax)
		{
			memoirePleine=true;
			nbConnaissances=0;
		}
		memoire[nbConnaissances++] = humain;
	}
	
	public void listerConnaissance() {
		String listNoms = " ";
		int nbIterations;
		if(memoirePleine)
			nbIterations = nbConnaissancesMax;
		else
			nbIterations = nbConnaissances;
		for(int i=0;i<nbIterations;i++) {
			listNoms += memoire[i].getNom();
			if(i!=nbIterations-1)
				listNoms += ", ";
		}
		parler("Je connais beaucoup de monde dont :" + listNoms);
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
