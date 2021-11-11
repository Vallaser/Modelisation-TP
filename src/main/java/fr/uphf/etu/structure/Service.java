package fr.uphf.etu.structure;

import fr.uphf.etu.flotte.Transport;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe Java pour créer un service
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Service {
    private final int idService;
    private int capacity;
    private List<Arc> chemin = new ArrayList<>();

    /**
     * Constructeur sans paramètres
     */
    public Service() {
        this.idService = (int) (Math.random() * (100 - 1));
    }

    /**
     * Constructeur avec 1 paramètre
     *
     * @param idService identifiant du service
     */
    public Service(int idService) {
        this.idService = idService;
    }

    /**
     * Constructeur avec 2 paramètres
     *
     * @param idService identifiant du service
     * @param capacity capacité du service
     */
    public Service(int idService, int capacity) {
        this.idService = idService;
        this.capacity = capacity;
    }

    /**
     * Constructeur avec 3 paramètres
     *
     * @param idService identifiant du service
     * @param capacity capacité du service
     * @param chemin chemin du service
     */
    public Service(int idService, int capacity, List<Arc> chemin) {
        this.idService = idService;
        this.capacity = capacity;
        this.chemin = chemin;
    }

    /**
     * Retourne l'identifiant du service
     *
     * @return l'identifiant du service
     */
    public int getIdService() {
        return idService;
    }

    /**
     * Retourne la capacity du service
     *
     * @return la capacity du service
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Retourne le chemin
     *
     * @return le chemin
     */
    public List<Arc> getChemin() {
        return chemin;
    }

    /**
     * Affiche l'identifiant du service
     */
    public void afficherID() {
        System.out.print("Id : " + idService + " ");
    }

    /**
     * Affiche la capacité du service
     */
    public void afficherCapacity() {
        System.out.print("Capacité : " + capacity + " ");
    }

    /**
     * Affiche les différentes routes du service
     */
    public void afficherRoute() {
        System.out.print("Route : ");
        chemin.forEach(
            c -> {
                c.afficherArc();
                System.out.print(" ");
            }
        );
    }

    /**
     * Affiche le Service
     */
    public void afficherService() {
        afficherID();
        afficherCapacity();
        afficherRoute();
        System.out.println();
    }
}
