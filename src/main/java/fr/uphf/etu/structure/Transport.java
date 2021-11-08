package fr.uphf.etu.structure;

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
    private int idTransport;
    private int taille;

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
     * Constructeur à un paramètre
     *
     * @param taille surface du transport en m³
     */
    public Transport(int taille) {
        this.idTransport = (int) (Math.random() * (100 - 1));//RandomStringUtils.random(8, "0123456789abcdef");
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
