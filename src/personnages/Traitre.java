package personnages;
import java.util.Random;


public class Traitre extends Samourai {
	private int niveauTraitrise=0;
	
	public Traitre(String nom, String seigneur, String boissonFavorite, int argent) {
		super(nom,seigneur,boissonFavorite,argent);
	}

	public int getNiveauTraitrise() {
		return niveauTraitrise;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon de niveau de traîtrise est : " + getNiveauTraitrise());
	}
	
	public void ranconner(Commercant commercant) {
		if(niveauTraitrise < 3) {
			int argentRanconne = commercant.getArgent()*2/10;
			commercant.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconne + " sous ou gare à toi");
			commercant.parler("Tout de suite grand " + this.getNom() + ".");
			niveauTraitrise++;
		}
		else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if(nbConnaissances < 1)
			parler("Je ne peux pas faire ami ami avec personne car je ne connais personne !");
		else {
			int don = getArgent()*1/20;
			Random random = new Random();
			int cible = random.nextInt(nbConnaissances);
			String nomAmi = memoire[cible].getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami! " + "Je voudrais vous aider en vous donnant " + don + " sous.");
			perdreArgent(don);
			memoire[cible].gagnerArgent(don);
			String nom = getNom();
			memoire[cible].parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
			if(niveauTraitrise>1) {
				niveauTraitrise--;
			}
		}
	}
	
	
}
