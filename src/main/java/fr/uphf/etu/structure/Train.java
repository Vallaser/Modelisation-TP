package fr.uphf.etu.structure;


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
     * Constructor à une entrée
     * @param taille surface du transport en m³
     */
    public Train(int taille) {
        super(taille);
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
