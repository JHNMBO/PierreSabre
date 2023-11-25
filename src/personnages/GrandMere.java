package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	protected int nbConnaissancesMax=5;
	
	private enum TypeHumain {
        COMMERCANT("un commercant"),
        RONIN("un ronin"),
        SAMOURAI("un samourai"),
        YAKUZA("un yakuza"),
        GRANDMERE("une grand-mère");
		
		private String nom;

		private TypeHumain(String nom) {
			this.nom = nom;
		}
		
		@Override
		public String toString() {
			return nom;
		}
    }
	
	public GrandMere(String nom, int argent) {
		super(nom,"tisane",argent);
	}
	
	@Override
	public void memoriser(Humain humain) {
		if(nbConnaissances<nbConnaissancesMax)
			memoire[nbConnaissances++] = humain;
		else 
			parler("Oh ma tête! Je ne peux plus retenir le nom d'une personne supplémentaire !");
	}
	
	private static String humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		Random random = new Random();
		int cible = random.nextInt(5);
		return types[cible].nom;
	}
	
	public void ragoter() {
		String nom;
		String type;
		for(int i=0;i<nbConnaissances;i++) {
			nom = memoire[i].getNom();
			type = humainHasard();
			if(memoire[i] instanceof Traitre)
				type = "un traître. Petit chenapan !";
			parler("Je crois que " + nom + " est " + type);
		}
	}
	
	public static void main(String[] args) {
		humainHasard();
	}
}
