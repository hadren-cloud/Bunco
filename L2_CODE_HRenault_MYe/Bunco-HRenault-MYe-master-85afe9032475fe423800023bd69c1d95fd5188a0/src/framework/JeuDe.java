package framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Classe generale d'un jeu de de 
 */
public class JeuDe extends Fabrique{
	private CollectionDes cDes;
	private CollectionJoueurs cJoueurs;
	private int nTours = 0;
	private int tourEnCours = 0;
	private Joueur joueurEnCours;
	private IStrategie jeuDeStrategie;

	/**
	 * Methode template pour jouer aux differentes implementations du jeu
	 */
	public final void jouer() {
		initialiserJeu();
		jouerTours();
		this.cJoueurs = (CollectionJoueurs) calculerVainqueur(this);
		afficherPoints();
	}
	
	/**
	 * Calcule le vainqueur du jeu
	 * @param jeu de de
	 * @return collections des  vainqueurs
	 */
	public CollectionJoueurs calculerVainqueur(JeuDe jD) {
		return (CollectionJoueurs) jeuDeStrategie.calculerVainqueur(jD);
	}
	
	/**
	 * Calculer le score d'un tour du jeu
	 * @param jeu de de
	 * @return si le joueur rejoue un autre tour
	 */
	public boolean calculerScoreTour(JeuDe jD) {
		return jeuDeStrategie.calculerScoreTour(jD);
	}
	
	/**
	 * initialise le jeu avec differentes variables necessaires au fonctionnement
	 * (nombre joueurs, nombre des, nombre de faces du de, nombre de tours, etc.)
	 */
	private void initialiserJeu() {
		int nombreJoueurs = 0;
		int nombreDes = 0;
		int nombreFaces = 0;
		Fabrique f = new Fabrique();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(nombreJoueurs < 1) {
			System.out.print("Nombre de joueurs: ");
			nombreJoueurs = Integer.parseInt(reader.readLine());
			}
			cJoueurs = new CollectionJoueurs(nombreJoueurs);
			
			while(nombreDes < 1) {
			System.out.print("Nombre de des par joueurs: ");
			nombreDes = Integer.parseInt(reader.readLine());
			}
			
			while(nombreFaces < 2) {
			System.out.print("Nombre de face du de: ");
			nombreFaces = Integer.parseInt(reader.readLine());
			}
			cDes = new CollectionDes(nombreDes);
			
			while(nTours < 1) {
			System.out.print("Nombre de tours : ");
			nTours = Integer.parseInt(reader.readLine());
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < nombreJoueurs; i++) {
			cJoueurs.add(creerJoueur());
		}
		for (int i = 0; i < nombreDes; i++) {
			cDes.add(creerDe(nombreFaces));
		}
	}

	/**
	 * Genere des nombres aleatoires pour les des lances
	 */
	private void brasserDes(){
		Iterator iter = cDes.iterator();
		while(iter.hasNext()){
			De d = (De) iter.next();
			d.lancerDe();
		}
	}

	/**
	 * Simule le jeu des tours du jeu pour chaque joueur, les differents lances de des etc.
	 */
	private void jouerTours(){
		for(int i = 0; i<nTours; i++){
			Iterator itrJoueur = cJoueurs.iterator();
			this.tourEnCours = i+1;
			System.out.println("\n------------------------------------------\nTOUR " + tourEnCours);
			while(itrJoueur.hasNext()){
				Joueur j = (Joueur) itrJoueur.next();
				this.joueurEnCours = j;
				boolean rejouer = true;

				System.out.println("\nJoueur: "+j.getNom());
				while(rejouer){
					brasserDes();
					rejouer = calculerScoreTour(this);
				}
				System.out.println("Total de points: "+j.getPoint());
			}
		}
	}

	private void afficherPoints(){
		System.out.println(cJoueurs.toString());
	}
	
	public CollectionJoueurs getCJoueurs(){
		return cJoueurs;
	}

	public CollectionDes getCDes(){
		return cDes;
	}

	public int getNTours(){
		return nTours;
	}

	public int getTourEnCours(){
		return tourEnCours;
	}

	public void setJeuDeStrategie(IStrategie jeuDeStrategie) {
		this.jeuDeStrategie = jeuDeStrategie;
	}

	public Joueur getJoueurEnCours(){
		return joueurEnCours;
	}

	
	public void setcDes(CollectionDes cDes) {
		this.cDes = cDes;
	}
	
	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public void setTourEnCours(int tourEnCours) {
		this.tourEnCours = tourEnCours;
	}

}
