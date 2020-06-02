package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import bunco.BuncoStrategy;
import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.De;
import framework.JeuDe;
import framework.Joueur;

public class JeuTest {

	BuncoStrategy bunco1;
	JeuDe jd1;
	De de1;
	De de2;
	De de3 ;
	
	/**
	 * Cree instance de bunco, du jeu de strategies, de 3 des et d'un joueur
	 */
	@Before
	public void faireAvant(){
		bunco1 = new BuncoStrategy();
		jd1 = new JeuDe();
		de1 = new De(6);
		de2 = new De(6);
		de3 = new De(6);
		Joueur j1 = new Joueur("1");
		jd1.setJoueurEnCours(j1);
	}
	
	/**
	 * Teste si le joueur obtient 21 points pour un bunco et si il ne peut pas rejouer
	 * @return true si le test fonctionne
	 */
	@Test
	public void testBunco() {
		de1.setFaceObtenue(1);de2.setFaceObtenue(1);de3.setFaceObtenue(1);
		CollectionDes cDes = new CollectionDes(3);
		cDes.add(de1);cDes.add(de2);cDes.add(de3);
		jd1.setcDes(cDes);
		jd1.setTourEnCours(1);
		bunco1 = new BuncoStrategy();
		bunco1.calculerScoreTour(jd1);
		assertTrue(bunco1.getPoint()==21 && bunco1.isCalculer() == false);
	}
	
	/**
	 * Teste si le joueur obtient 5 points pour 3 des similaires 
	 * mais pas egal au nb Tours et si il peut rejouer
	 * @return true si le test fonctionne
	 */
	@Test
	public void testCinqPts() {
		de1.setFaceObtenue(1);de2.setFaceObtenue(1);de3.setFaceObtenue(1);
		CollectionDes cDes = new CollectionDes(3);
		cDes.add(de1);cDes.add(de2);cDes.add(de3);
		jd1.setcDes(cDes);
		jd1.setTourEnCours(2);
		bunco1 = new BuncoStrategy();
		bunco1.calculerScoreTour(jd1);
		assertTrue(bunco1.getPoint()==5 && bunco1.isCalculer());
	}
	
	/**
	 * Teste si le joueur obtient 1 point pour 1 chiffre similaire au nombre 
	 * du tour et si il peut rejouer
	 * @return true si le test fonctionne
	 */
	@Test
	public void testUnChiffre() {
		de1.setFaceObtenue(1);de2.setFaceObtenue(2);de3.setFaceObtenue(2);
		CollectionDes cDes = new CollectionDes(3);
		cDes.add(de1);cDes.add(de2);cDes.add(de3);
		jd1.setcDes(cDes);
		jd1.setTourEnCours(1);
		bunco1 = new BuncoStrategy();
		bunco1.calculerScoreTour(jd1);
		assertTrue(bunco1.getPoint()==1 && bunco1.isCalculer());
	}
	
	/**
	 * Teste si le joueur obtient 0 point pour aucune chiffre similaire
	 * si il ne peut pas rejouer
	 * @return true si le test fonctionne
	 */
	@Test
	public void testZeroPoint() {
		de1.setFaceObtenue(1);de2.setFaceObtenue(2);de3.setFaceObtenue(3);
		CollectionDes cDes = new CollectionDes(3);
		cDes.add(de1);cDes.add(de2);cDes.add(de3);
		jd1.setcDes(cDes);
		jd1.setTourEnCours(4);
		bunco1 = new BuncoStrategy();
		bunco1.calculerScoreTour(jd1);
		assertTrue(bunco1.getPoint()==0 && bunco1.isCalculer() == false);
	}
	
	/**
	 * Teste l'affichage du classement pour 3 joueurs dont les valeurs des dont pre-definis
	 * Classement devrait etre : 2 > 3 > 1
	 * @return true si le test fonctionne
	 */
	@Test
	public void testClassement() {		
		CollectionDes cDes = new CollectionDes(3);
		cDes.add(de1);cDes.add(de2);cDes.add(de3);
		CollectionJoueurs cJoueurs = new CollectionJoueurs(3);
		Joueur t1 = new Joueur("1");Joueur t2 = new Joueur("2");Joueur t3 = new Joueur("3");
		cJoueurs.add(t1);cJoueurs.add(t2);cJoueurs.add(t3);
		
		bunco1 = new BuncoStrategy();
		
		//creer des joueur 1
		de1.setFaceObtenue(1);de2.setFaceObtenue(2);de3.setFaceObtenue(3);
		jd1.setcDes(cDes);
		jd1.setTourEnCours(1);
		jd1.setJoueurEnCours(t1);
		bunco1.calculerScoreTour(jd1);
		//creer des joueur 2
		de1.setFaceObtenue(1);de2.setFaceObtenue(1);de3.setFaceObtenue(1);
		jd1.setcDes(cDes);
		jd1.setJoueurEnCours(t2);
		bunco1.calculerScoreTour(jd1);
		//creer des joueur 3
		de1.setFaceObtenue(3);de2.setFaceObtenue(3);de3.setFaceObtenue(3);
		jd1.setcDes(cDes);
		jd1.setJoueurEnCours(t3);
		bunco1.calculerScoreTour(jd1);
		
		//sort et afficher gagnants
		Joueur[] arrJoueurs = (Joueur[]) cJoueurs.toArray();
		Arrays.sort(arrJoueurs, Joueur::compareTo);
		int grosseur = cJoueurs.size();
		CollectionJoueurs cJoueurs1 = new CollectionJoueurs(grosseur);
		for (Joueur j : arrJoueurs) {
			cJoueurs1.add(j);
		}	
		System.out.println(cJoueurs1.toString());
		Iterator itrJoueur = cJoueurs1.iterator();
		//verifie que le gagnant est le joueur 2 (le joueur avec un bunco)
		assertTrue(((Joueur) itrJoueur.next()).getNom().equals("2"));
	}
}
