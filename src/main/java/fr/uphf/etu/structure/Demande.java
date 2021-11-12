package fr.uphf.etu.structure;


/**
 *
 * Classe Java pour créer une Demande
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Demande {
    private final int idDemande;
    private Noeud noeudDepart;
    private Noeud noeudArrivee;
    private int heureDepart;
    private int heureArrivee;
    private int volume;
    private Noeud position = null;

    /**
     * Constructeur vide
     */
    public Demande() {
        this.idDemande = (int) (Math.random() * (100 - 1));
    }

    /**
     * Constructeur avec 1 paramètre
     *
     * @param idDemande identifiant de la demande
     */
    public Demande(int idDemande) {
        this.idDemande = idDemande;
    }

    /**
     * Constructeur avec 3 paramètres
     *
     * @param idDemande identifiant de la demande
     * @param noeudDepart noeud de départ de la demande
     * @param noeudArrivee noeud d'arrivée de la demande
     */
    public Demande(int idDemande, Noeud noeudDepart, Noeud noeudArrivee) {
        this.idDemande = idDemande;
        this.noeudDepart = noeudDepart;
        this.noeudArrivee = noeudArrivee;
    }

    /**
     * Constructeur avec 6 paramètres
     *
     * @param idDemande identifiant de la demande
     * @param noeudDepart noeud de départ de la demande
     * @param noeudArrivee noeud d'arrivée de la demande
     * @param heureDepart heure de départ de la demande
     * @param heureArrivee heure d'arrivée de la demande
     * @param volume volume de la demande
     */
    public Demande(int idDemande, Noeud noeudDepart, Noeud noeudArrivee, int heureDepart, int heureArrivee, int volume) {
        this.idDemande = idDemande;
        this.noeudDepart = noeudDepart;
        this.noeudArrivee = noeudArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.volume = volume;
    }

    /**
     * Modifie la position de la demande
     *
     * @param position de la demande
     */
    public void setPosition(Noeud position) {
        this.position = position;
    }

    /**
     * Retourne l'identifiant de la demande
     *
     * @return l'identifiant de la demande
     */
    public int getIdDemande() {
        return idDemande;
    }

    /**
     * Retourne le noeud de départ de la demande
     *
     * @return le noeud de départ de la demande
     */
    public Noeud getNoeudDepart() {
        return noeudDepart;
    }

    /**
     * Retourne le noeud d'arrivée de la demande
     *
     * @return le noeud d'arrivée de la demande
     */
    public Noeud getNoeudArrivee() {
        return noeudArrivee;
    }

    /**
     * Retourne l'heure du départ de la demande
     *
     * @return l'heure du départ de la demande
     */
    public int getHeureDepart() {
        return heureDepart;
    }

    /**
     * Retourne l'heure d'arrivée de la demande
     *
     * @return l'heure d'arrivée de la demande
     */
    public int getHeureArrivee() {
        return heureArrivee;
    }

    /**
     * Retourne le volume de la demande
     *
     * @return le volume de la demande
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Retourne la position de la demande
     *
     * @return la position de la demande
     */
    public Noeud getPosition() { return position; }

    /**
     * Affiche l'identifiant de la demande
     */
    public void afficherIdDemande()
    {
        System.out.print(idDemande);
    }


    /**
     * Affiche le Noeud de départ et d'arrivée
     */
    public void afficherNoeuds()
    {
        System.out.print(noeudDepart.getLettre());
        System.out.print(", ");
        System.out.print(noeudArrivee.getLettre());
    }

    /**
     * Affiche l'heure de d"part et d'arrivée
     */
    public void afficherHeures()
    {
        System.out.print(heureDepart + ", " + heureArrivee);
    }

    /**
     * Affiche le volume de la demande
     */
    public void afficherVolume()
    {
        System.out.print(volume);
    }

    /**
     * Affiche la position de la demande
     */
    public void affichePosition() { System.out.print(position.getLettre());}

    /**
     * Affiche la demande
     */
    public void afficherDemande()
    {
        afficherIdDemande();
        System.out.print("\t");
        afficherNoeuds();
        System.out.print("\t");
        afficherHeures();
        System.out.print("\t");
        afficherVolume();
        System.out.print("\t");
        affichePosition();
        System.out.println();

    }
}
