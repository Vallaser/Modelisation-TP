package fr.uphf.etu.structure;


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
     * Constructor à une entrée
     * @param taille surface du transport en m³
     */
    public Camion(int taille) {
        super(taille);
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
