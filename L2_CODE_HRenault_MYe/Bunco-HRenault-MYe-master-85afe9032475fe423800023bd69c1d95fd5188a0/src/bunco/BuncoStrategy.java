package bunco;

import java.util.Arrays;
import java.util.Iterator;

import framework.*;

/**
 * Classe qui implémente la stratégie bunco et permet de calculer le vainqueur
 * et le nombre de points de chaque joueur selon les règles du Bunco
 */
/**
 * @author AP71850
 *
 */
public class BuncoStrategy implements IStrategie {

	/**
	 * Variables utilisées pour le calcul des différentes possibilités du Bunco
	 */
	private boolean calculer;
	private int point;
	private int ptsCinq = 0;
	private int compteurBunco = 0;
	private int compteurCinq = 0;

	/**
	 * Sort la collection de joueurs en ordre décroissant pour afficher
	 * le classement des joueurs (du vainqueur au dernier)
	 * @return La collection des joueurs triés par points
	 */
	@Override
	public CollectionJoueurs calculerVainqueur(JeuDe jD) {
		Joueur[] arrJoueurs = (Joueur[]) jD.getCJoueurs().toArray();
		Arrays.sort(arrJoueurs, Joueur::compareTo);
		int grosseur = jD.getCJoueurs().size();
		CollectionJoueurs cJoueurs = new CollectionJoueurs(grosseur);
		for (Joueur j : arrJoueurs) {
			cJoueurs.add(j);
		}
		return cJoueurs;
	}

	/**
	 * Calcule le score d'un joueur pour le tour en cours
	 * @return si le joueur relance les dés
	 */
	@Override
	public boolean calculerScoreTour(JeuDe jD) {
		point = 0;
		calculer = false;

		Iterator itrDe = jD.getCDes().iterator();
		while (itrDe.hasNext()) {
			De d = (De) itrDe.next();

			// pour calculer le cas de 3 chiffres pas egal au tour
			if (d.compareTo(ptsCinq) == 0) {
				compteurCinq++;
			}
			ptsCinq = d.getNombre();

			// pour ajouter un point quand nombre de = nombre tour et pour gerer cas de
			// bunco
			if (d.compareTo(jD.getTourEnCours()) == 0) {
				point++;
				calculer = true;
				compteurBunco++;
			}
		}

		System.out.println("|" + jD.getCDes().toString());

		//quand le joueur a 3 chiffres égaux, mais pas égaux au nombre du tour en cours
		if (compteurCinq == 2) {
			point = 5;
			calculer = true;
		}

		//quand le joueur a 3 chiffres égaux et égaux au nombre du tour en cours
		if (compteurBunco == 3) {
			System.out.println("\tBUNCO");
			point = 21;
			calculer = false;
		}

		//ajoute les points au joueur
		jD.getJoueurEnCours().ajouterPoint(point);

		ptsCinq = 0;
		compteurBunco = 0;
		compteurCinq = 0;

		return calculer;
	}

	/**
	 * @return le nombre de points du joueur pour le tour en cours
	 */
	public int getPoint() {
		return point;
	}
	
	/**
	 * @return si le joueur rejoue ou non
	 */
	public boolean isCalculer() {
		return calculer;
	}
}
