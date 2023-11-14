package histoire;

import personnages.Commercant;
import personnages.Yakuza;

public class HistoireTP4 {
	public static void main(String[] args) {
		Commercant marco = new Commercant("Marco",110);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire("thé");
		Yakuza yaku = new Yakuza("Yaku","whisky",20,"yakuza");
		yaku.direBonjour();
		yaku.extorquer(marco);
	}
}
