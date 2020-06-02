package framework;

import java.util.Random;

/**
 * Gere les proprietes des des et les differentes actions possibles avec les des
 */
public class De implements Comparable {
	private int nombreDeFace;
	private int nombre;
	private Random r;
	
	public De(int nombreDeFace) {
		this.nombreDeFace = nombreDeFace;
		this.nombre = 0;
	}
	
	/**
	 * @return le nombre sur le de
	 */
	public int getNombre() {
		return nombre;
	}
	
	/**
	 * Genere un nombre random selon le nombre de faces du de
	 */
	public void lancerDe() {
		r = new Random();
		this.nombre = r.nextInt(nombreDeFace) + 1;
	}

	/* 
	 * Compare deux valeurs de de
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof De) {
			De d = (De) o;
			// Si la valeur d'un des des est plus grande que le nombre de faces
			if (d.getNombre() > nombreDeFace || nombre > nombreDeFace) {
				throw new IndexOutOfBoundsException("Out of bounds");
			}
			// Deux des egaux
			if (d.getNombre() == nombre) {
				return 0;
			}
			// De plus grand
			else if (d.getNombre() > nombre) {
				return 1;
			}
			// De plus petit
			else {
				return -1;
			}
			// Si valeur en parametre est un integer
		} else if (o instanceof Integer) {
			int num = (int) o;
			if (num == nombre) {
				return 0;
			} else if (num > nombre) {
				return 1;
			} else {
				return -1;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Pour donner une valeur a la face dans les tests JUnit
	 * @param i la valeur du de obtenue
	 */
	public void setFaceObtenue(int i) {
		if (i < 1) {
			throw new IllegalArgumentException();
		}
		else {
			this.nombre = i;	
		}
	}
}
