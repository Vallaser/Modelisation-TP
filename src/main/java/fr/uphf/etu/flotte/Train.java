package fr.uphf.etu.flotte;


/**
 *
 * Classe Java pour créer un Train
 *
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Train extends Transport {

    /**
     * Constructeur vide
     */
    public Train() { super(); }

    /**
     * Constructor à une entrée
     * @param idTransport identifiant de ce train parmi les transports
     */
    public Train(int idTransport) {
        super(idTransport);
    }

    /**
     * Constructeur à deux entrées
     *
     * @param idTransport identifiant de ce train parmi les transports
     * @param taille surface du transport en m³
     */
    public Train(int idTransport, int taille) {
        super(idTransport, taille);
    }
}
