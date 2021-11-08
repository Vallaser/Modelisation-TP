package fr.uphf.etu.structure;


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
     * Constructor à une entrée
     * @param taille surface du transport en m³
     */
    public Bateau(int taille) {
        super(taille);
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
