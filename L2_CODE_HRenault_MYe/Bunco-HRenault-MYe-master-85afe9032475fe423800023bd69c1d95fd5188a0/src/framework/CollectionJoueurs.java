package framework;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection des joueurs du jeu 
 */
public class CollectionJoueurs implements Collection<Joueur> {
    private Joueur[] arrJoueur;
    private int compteur = 0;

    /**
     * Cr�e une collection de la taille du nombre de joueurs
     * @param nombre de joueurs du jeu
     */
    public CollectionJoueurs(int nombre) {
    	arrJoueur = new Joueur[nombre];
    }
    
	/**
	 * Ajoute un joueur dans la collection
	 */
	@Override
	public boolean add(Joueur arg0) {
	    arrJoueur[compteur] = arg0;
	    compteur++;
		return false;
	}

	@Override
	public boolean addAll(Collection arg0) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object arg0) {
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator iterator() {
		return new JoueursIterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return false;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		return false;
	}

	/**
	 * @return la taille de la collection
	 */
	@Override
	public int size() {
		return compteur;
	}

	@Override
	public Object[] toArray() {
		return arrJoueur;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		return null;
	}
	
	/**
	 * Permet d'it�rer sur la collection de joueurs pour passer de
	 * joueur � joueur pendant le jeu
	 */
	private class JoueursIterator implements Iterator<Joueur> {

		int index;

		
		/**
		 * @return true jusqu'� ce que tous les joueurs sont parcourus
		 */
		@Override
		public boolean hasNext() {

			if (index < arrJoueur.length) {
				return true;
			}
			return false;
		}

		
		/**
		 * @return le prochain joueur
		 */
		@Override
		public Joueur next() {

			if (this.hasNext()) {
				return arrJoueur[index++];
			}
			return null;
		}
	}

	/**
	 * Affiche le classement des joueurs apr�s le jeu
	 */
	@Override
	public String toString() {
    	String results = "\nClassement de points";

		int index = 1;
		for(Joueur j : arrJoueur){
			results += "\n"+index+": "+j.toString();
			index++;
		}

		return results;
	}
}
