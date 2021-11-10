package fr.uphf.etu.structure;


import java.util.List;

/**
 *
 * Classe Java pour créer un Noeud
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Noeud {
    private char lettre;
    private List<Noeud> liens;

    /**
     * Constructeur sans paramètres
     */
    public Noeud()
    {
        this.lettre = (char) (Math.random() * (100 - 1));
    }

    /**
     * Constructeur avec 1 paramètre
     *
     * @param lettre lettre qui symbolise le noeud
     */
    public Noeud(char lettre)
    {
        this.lettre = lettre;
    }

    /**
     * Constructeur avec 2 paramètres
     *
     * @param lettre lettre qui symbolise le noeud
     * @param liens les liens du noeud sur les autres noeuds
     */
    public Noeud(char lettre, List<Noeud> liens)
    {
        this.lettre = lettre;
        this.liens = liens;
    }

    /**
     * Modifie la liste des liens
     * @param liens vers les noeuds
     */
    public void setLiens(List<Noeud> liens) {
        this.liens = liens;
    }

    /**
     * Retourne la lettre qui symbolise ce noeud
     *
     * @return la lettre qui symbolise ce noeud
     */
    public char getLettre() {
        return lettre;
    }

    /**
     * Retourne la liste des liens du noeud vers les autres noeuds
     *
     * @return la liste des liens du noeud vers les autres noeuds
     */
    public List<Noeud> getLiens() {
        return liens;
    }

    /**
     * Affiche la lettre symbolisant le noeud
     */
    public void afficherLettre() {
        System.out.print("Lettre : " + this.lettre);
    }


    /**
     * Affiche les liens du noeud
     */
    public void afficherLiens(){
        System.out.print("Liens : ");
        liens.forEach(
                l -> System.out.print(l.getLettre() + " ")
        );
    }
}
