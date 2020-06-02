package tests;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import framework.Joueur;

/**
 * Teste les differentes instances possibles des joueurs
 * et les comparaisons entre differents joueurs 
 */
public class JoueurTest {

	private Joueur j1;
	private Joueur j2;

	/**
	 * Cree 2 instances de joueurs
	 */
	@Before
	public void faireAvant(){
		j1 = new Joueur("1");
		j2 = new Joueur("2");
	}
	
	/**
	 * Teste si le valeur de return de compareTo fonctionne pour un joueur avec plus de points
	 * @return true si le test fonctionne
	 */
	@Test
	public void joueurSuperieurTest(){
		j1.setPoints(4);
		j2.setPoints(5);
		assertTrue(j1.compareTo(j2)==1);
	}
	
	/**
	 * Teste si le valeur de return de compareTo fonctionne pour un joueur avec moins de points
	 * @return true si le test fonctionne
	 */
	@Test
	public void joueurInferieurTest(){
		j1.setPoints(5);
		j2.setPoints(4);
		assertTrue(j1.compareTo(j2)==-1);
	}
	
	/**
	 * Teste si le valeur de return de compareTo fonctionne pour 2 joueurs avec le meme nombre de points
	 * @return true si le test fonctionne
	 */
	@Test
	public void joueursEgauxTest(){
		j1.setPoints(5);
		assertTrue(j1.compareTo(j1)==0);
	}
	
	/**
	 * Teste si l'exception fonctionne pour un joueur null
	 * @return IllegalArgumentException si test fonctionne
	 */
	@Test(expected=IllegalArgumentException.class)
	public void joueurNullTest(){
		j1.setPoints(1);
		j1.compareTo(null);
	}
	
	/**
	 * Teste si l'exception fonctionne pour la methode setPoints(int) avec un parametre negatif
	 * @return IllegalArgumentException si test fonctionne
	 */
	@Test(expected=IllegalArgumentException.class)
	public void joueurNegatifTest(){
		j1.setPoints(-1);
	}
	
	/**
	 * Teste si l'exception fonctionne pour la methode ajouterPoints(int) avec un parametre negatif
	 * @return IllegalArgumentException si test fonctionne
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void pointNegatifTest(){
		j1.ajouterPoint(-1);
	}

}