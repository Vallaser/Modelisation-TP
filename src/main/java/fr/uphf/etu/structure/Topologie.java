package fr.uphf.etu.structure;

import fr.uphf.etu.exception.IdentifiantTransportDejaExistant;
import fr.uphf.etu.flotte.Bateau;
import fr.uphf.etu.flotte.Camion;
import fr.uphf.etu.flotte.Train;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    private List<Noeud> noeuds = new ArrayList<>();

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
     * Lit un fichier texte d'une topologie
     *
     * @param cheminFichier chelin du Fichier texte
     */
    public void lireTopologie(String cheminFichier) {
        try {
            File file = new File(cheminFichier);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while((line = br.readLine()) != null)
            {
                String[] mots = line.split("\t",2);
                line = line.substring(mots[0].length());
                while(line.charAt(0) == '\t')
                {
                    line = line.substring(1,line.length());
                }
                String[] lettres = line.split(" ");
                List<Noeud> liens = new ArrayList<>();
                for(int i=0;i<lettres.length;i++)
                {
                    boolean trouver = false;
                    for(Noeud noeud : noeuds)
                    {
                        if(noeud.getLettre() == lettres[i].charAt(0))
                        {
                            liens.add(noeud);
                            trouver = true;
                            break;
                        }
                    }
                    if(!trouver)
                    {
                        Noeud nouveauNoeud = new Noeud(lettres[i].charAt(0));
                        noeuds.add(nouveauNoeud);
                        liens.add(nouveauNoeud);
                    }

                }
                boolean trouver = false;
                for(Noeud noeud : noeuds)
                {
                    if(noeud.getLettre() == mots[0].charAt(0))
                    {
                        noeud.setLiens(liens);
                        trouver = true;
                        break;
                    }
                }
                if(!trouver)
                {
                    Noeud nouveauNoeud = new Noeud(mots[0].charAt(0), liens);
                    noeuds.add(nouveauNoeud);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Retourne la liste des noeuds
     *
     * @return la liste des noeuds
     */
    public List<Noeud> getNoeuds() {
        return noeuds;
    }

    /**
     * Affiche la topologie
     */
    public void afficherTopologie() {
        System.out.println("Noeud\tLiens");
        noeuds.forEach(
                n -> {
                    n.afficherLettre();
                    System.out.print("\t");
                    n.afficherLiens();
                    System.out.println();
                }
        );
    }
}
