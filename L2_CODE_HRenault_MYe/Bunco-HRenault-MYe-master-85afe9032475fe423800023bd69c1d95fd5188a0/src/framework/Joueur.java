package framework;

/**
 * Gere les proprietes des des et les differentes actions possibles avec les des
 */
public class Joueur implements Comparable {
	private String nom;
	private int point;

	public Joueur(String nom) {
		this.nom = nom;
		this.point = 0;
	}

	/**
	 * Ajoute points au joueur
	 * @param nombre de points a ajouter au joueur
	 */
	public void ajouterPoint(int point) {
		if (point < 0) {
			throw new IndexOutOfBoundsException();
		}
		this.point += point;
	}

	/**
	 * @return le nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return le nombre de points du joueur
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * Compare le joueur actuel au joueur passe en parametre
	 * @param joueur a comparer
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof Joueur) {
			Joueur j = (Joueur) o;
			// joueur superieur
			if (j.getPoint() > point) {
				return 1;
			}
			// joueur inferieur
			else if (j.getPoint() < point) {
				return -1;
			}
			// joueur egal
			else {
				return 0;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Pour affichage classements
	 */
	@Override
	public String toString() {
		return " " + nom + " avec " + point + " points.";
	}

	/**
	 * Change le nombre de points du joueur
	 * @param le nouveau nombre de points du joueur
	 */
	public void setPoints(int i) {
		if (i < 0) {
			throw new IllegalArgumentException();
		} else {
			point = i;
		}
	}
}
