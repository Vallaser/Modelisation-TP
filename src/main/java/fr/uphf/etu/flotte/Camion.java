package fr.uphf.etu.flotte;


/**
 *
 * Classe Java pour créer un Camion
 *
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Camion extends Transport {

    /**
     * Constructeur vide
     */
    public Camion() { super(); }

    /**
     * Constructor à une entrée
     * @param idTransport identifiant de ce train parmi les transports
     */
    public Camion(int idTransport) {
        super(idTransport);
    }

    /**
     * Constructeur à deux entrées
     *
     * @param idTransport identifiant de ce camion parmi les transports
     * @param taille surface du transport en m³
     */
    public Camion(int idTransport, int taille) {
        super(idTransport, taille);
    }
}
