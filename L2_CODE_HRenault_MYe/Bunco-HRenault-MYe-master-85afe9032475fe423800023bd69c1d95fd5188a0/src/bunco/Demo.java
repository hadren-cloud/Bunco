package bunco;

import framework.JeuDe;

/**
 * Contient la méthode main
 * Crée une instance d'un jeu de stratégie 
 * (Dans ce cas-ci : un jeu de Bunco)
 */
public class Demo {
	public static void main(String[] args) {
		JeuDe jD = new JeuDe();
		BuncoStrategy bStrat = new BuncoStrategy();
		jD.setJeuDeStrategie(bStrat);
		jD.jouer();
	}
}
