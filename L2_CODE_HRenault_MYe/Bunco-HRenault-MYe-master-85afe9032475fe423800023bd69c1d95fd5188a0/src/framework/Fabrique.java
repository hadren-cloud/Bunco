package framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Permet de creer les instances des joueurs et des des
 */
public class Fabrique {

	/**
	 * @return un joueur avec un nom
	 */
	public Joueur creerJoueur() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String nomJoueur = null;
		while(true){
			System.out.print("Nom du joueur: ");
			try {
				nomJoueur = reader.readLine();
				if(nomJoueur != null && !("".equals(nomJoueur))){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Joueur(nomJoueur);
	}

	/**
	 * @param le nombre de faces du de
	 * @return un de avec un nombre de faces
	 */
	public De creerDe(int nombreFaces) {
		return new De(nombreFaces);
	}
}
