package framework;

/**
 * Patron strategie, permet d'implémenter differentes strategies selon le jeu
 */
public interface IStrategie {
    Object calculerVainqueur(JeuDe jD);
    boolean calculerScoreTour(JeuDe jD);
}
