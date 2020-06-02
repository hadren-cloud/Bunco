package tests;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import framework.De;

/**
 * Teste les differentes instances possibles de des
 * et les comparaisons entre differentes des utilises 
 * pour le calcul du score
 */
public class DeTest {

	private De de1;
	private De de2;

	/**
	 * Cree 2 instances de des a 6 faces
	 */
	@Before
	public void faireAvant(){
		de1 = new De(6);
		de2 = new De(6);
	}

	/**
	 * Teste si le valeur de return de compareTo fonctionne pour un des plus grand
	 * @return true si le test fonctionne
	 */
	@Test
	public void deSuperieurTest(){
		de1.setFaceObtenue(4);
		de2.setFaceObtenue(5);
		assertTrue(de1.compareTo(de2)==1);
	}
	
	/**
	 * Teste si le valeur de return de compareTo fonctionne pour un des plus petit
	 * @return true si le test fonctionne
	 */
	@Test
	public void deInferieurTest(){
		de1.setFaceObtenue(4);
		de2.setFaceObtenue(5);
		assertTrue(de2.compareTo(de1)==-1);
	}

	/**
	 * Teste si le valeur de return de compareTo fonctionne pour deux des egaux
	 * @return true si le test fonctionne
	 */
	@Test
	public void memeDeTest(){
		de1.setFaceObtenue(4);
		assertTrue(de1.compareTo(de1)==0);
	}
	
	/**
	 * Teste si l'exception fonctionne pour un de negatif
	 * @return IllegalArgumentException si test fonctionne
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deNegatifTest(){
		de1.setFaceObtenue(-3);
	}

	/**
	 * Teste si l'exception fonctionne pour un de null
	 * @return IllegalArgumentException si test fonctionne
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deNullTest(){
		de1.setFaceObtenue(4);
		de1.compareTo(null);
	}
	
	/**
	 * Teste si l'exception fonctionne pour un de plus grand que le nombre de faces
	 * @return IndexOutOfBoundsException si test fonctionne
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void deOutOfBounds(){
		de1.setFaceObtenue(8);
		de2.setFaceObtenue(2);
		assertTrue(de1.compareTo(de2)==-1);
	}
}