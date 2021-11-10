package fr.uphf.etu.flotte;


/**
 *
 * Classe Java pour créer un Bateau hérite de Transport
 *
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Bateau extends Transport {

    /**
     * Constructeur vide
     */
    public Bateau() { super(); }

    /**
     * Constructor à une entrée
     * @param idTransport identifiant de ce train parmi les transports
     */
    public Bateau(int idTransport) {
        super(idTransport);
    }

    /**
     * Constructeur à deux entrées
     *
     * @param idTransport identifiant de ce bateau parmi les transports
     * @param taille surface du transport en m³
     */
    public Bateau(int idTransport, int taille) {
        super(idTransport, taille);
    }
}
