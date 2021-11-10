package fr.uphf.etu.structure;

import java.util.List;

/**
 *
 * Classe Java pour créer une topologie
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Topologie {
    public List<Noeud> noeuds;

    /**
     * Constructeur vide
     */
    public Topologie() {
    }

    /**
     * Constructeur avec 1 paramètre
     *
     * @param noeuds la liste des noeuds
     */
    public Topologie(List<Noeud> noeuds) {
        this.noeuds = noeuds;
    }

    /**
     * Retourne la liste des noeuds
     *
     * @return la liste des noeuds
     */
    public List<Noeud> getNoeuds() {
        return noeuds;
    }
}
