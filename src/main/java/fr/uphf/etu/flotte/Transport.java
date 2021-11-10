package fr.uphf.etu.flotte;

/**
 *
 * Classe Java pour créer un Transport
 * Camion/Train/Bateau
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Transport {
    private final int idTransport;
    private int taille;


    /**
     * Constructeur vide
     */
    public Transport() {
        this.idTransport = (int) (Math.random() * (100 - 1));//RandomStringUtils.random(8, "0123456789abcdef");
    }

    /**
     * Constructeur à un paramètre
     *
     * @param idTransport identifiant de ce transport
     */
    public Transport(int idTransport) {
        this.idTransport = idTransport;
    }

    /**
     * Constructeur à deux paramètres
     *
     * @param idTransport identifiant de ce transport
     * @param taille surface du transport en m³
     */
    public Transport(int idTransport, int taille) {
        this.idTransport = idTransport;
        this.taille = taille;
    }

    /**
     * Retourne l'identifiant de ce transport
     *
     * @return l'identifiant du transport
     */
    public int getIdTransport() {
        return idTransport;
    }

    /**
     * Retourne la taille de ce transport en m³
     *
     * @return la taille de ce transport en m³
     */
    public int getTaille() {
        return taille;
    }

}
