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
    private List<Service> services = new ArrayList<>();

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
     * Construcetur avec 2 paramètres
     *
     * @param noeuds la liste des noeuds
     * @param services la liste des services
     */
    public Topologie(List<Noeud> noeuds, List<Service> services) {
        this.noeuds = noeuds;
        this.services = services;
    }

    /**
     * Lit un fichier texte d'une topologie
     *
     * @param cheminFichier chemin du Fichier texte
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
     * Lit un fichier texte de services
     *
     * @param cheminFichier chemin du Fichier texte
     */
    public void lireServices(String cheminFichier) {
        try {
            File file = new File(cheminFichier);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while((line = br.readLine()) != null)
            {
                line = line.substring(0,line.length()-1);
                String[] mots = line.split("\t",3);
                String[] arcs = mots[2].split("; ");
                List<Arc> nouvelleRoute = new ArrayList<>();
                for(int i=0;i<arcs.length;i++)
                {
                    String[] depart_arrivee = arcs[i].split(", ");
                    boolean trouver = false;
                    for(Noeud noeudDepart : noeuds)
                    {
                        if(noeudDepart.getLettre() == depart_arrivee[0].charAt(0))
                        {
                            for(Noeud noeudArrivee : noeuds)
                            {
                                if(noeudArrivee.getLettre() == depart_arrivee[1].charAt(0))
                                {
                                    Arc nouvelArc = new Arc(noeudDepart,noeudArrivee,Integer.parseInt(depart_arrivee[0].substring(1)),Integer.parseInt(depart_arrivee[1].substring(1)));
                                    nouvelleRoute.add(nouvelArc);
                                    trouver = true;
                                    break;
                                }
                            }
                        }
                        if(trouver)
                        {
                            break;
                        }
                    }
                }
                Service nouveauService = new Service(Integer.parseInt(mots[0]),Integer.parseInt(mots[1]),nouvelleRoute);
                nouveauService.afficherService();
                services.add(nouveauService);
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
     * Retourne la liste des services
     *s.afficherID();
     *                     System.out.print("\t");
     *                     s.afficherCapacity();
     *                     System.out.print("\t");
     * @return la liste des services
     */
    public List<Service> getServices() {
        return services;
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

    public void afficherServices() {
        System.out.println("ID\tCapacity\tRoute");
        services.forEach(
                s -> {
                    s.afficherService();
                    System.out.println();
                }
        );
    }
}
