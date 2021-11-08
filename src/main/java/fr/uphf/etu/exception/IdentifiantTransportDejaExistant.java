package fr.uphf.etu.exception;


/**
 *
 * Classe Java Exception pour avertir d'un ID commun entre deux transports hérite de Exception
 *
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class IdentifiantTransportDejaExistant extends Exception {

    /**
     * Constructeur vide
     */
    public IdentifiantTransportDejaExistant() {
        super();
    }

    /**
     * Constructeur à une entrée
     *
     * @param s chaine de caractère de l'erreur
     */
    public IdentifiantTransportDejaExistant(String s) {
        super(s);
    }
}
