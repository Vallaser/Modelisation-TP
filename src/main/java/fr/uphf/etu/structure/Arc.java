package fr.uphf.etu.structure;

/**
 *
 * Classe Java pour créer un Arc
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Arc {
    private Noeud noeudDepart;
    private Noeud noeudArrivee;
    private int heureDepart;
    private int heureArrivee;

    /**
     * Constructeur sans paramètres
     */
    public Arc() {
    }

    /**
     * Constructeur avec 2 paramètres
     *
     * @param noeudDepart noeud de départ
     * @param noeudArrivee noeud d'arrivée
     */
    public Arc(Noeud noeudDepart, Noeud noeudArrivee) {
        this.noeudDepart = noeudDepart;
        this.noeudArrivee = noeudArrivee;
    }

    /**
     * Constructeur avec 4 paramètres
     *
     * @param noeudDepart noeud de départ
     * @param noeudArrivee noeud d'arrivée
     * @param heureDepart heure de départ
     * @param heureArrivee heure d'arrivée
     */
    public Arc(Noeud noeudDepart, Noeud noeudArrivee, int heureDepart, int heureArrivee) {
        this.noeudDepart = noeudDepart;
        this.noeudArrivee = noeudArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    /**
     * Retourne le noeud de départ
     *
     * @return le noeud de départ
     */
    public Noeud getDepart() {
        return noeudDepart;
    }

    /**
     * Retourne le noeud d'arrivée
     *
     * @return le noeud d'arrivée
     */
    public Noeud getArrivee() {
        return noeudArrivee;
    }

    /**
     * Retourne l'heure de départ
     *
     * @return l'heure de départ
     */
    public int getHeureDepart() {
        return heureDepart;
    }

    /**
     * Retourne l'heure d'arrivée
     *
     * @return l'heure d'arrivée
     */
    public int getHeureArrivee() {
        return heureArrivee;
    }

    /**
     * Affiche le départ
     */
    public void afficherDepart() {
        System.out.print(noeudDepart.getLettre());
        System.out.print(heureDepart);
    }

    /**
     * Affiche l'arrivée
     */
    public void afficherArrivee() {
        System.out.print(noeudArrivee.getLettre());
        System.out.print( heureArrivee);
    }

    /**
     * Affiche l'arc
     */
    public void afficherArc() {
        afficherDepart();
        System.out.print(", ");
        afficherArrivee();
        System.out.print("; ");
    }
}
