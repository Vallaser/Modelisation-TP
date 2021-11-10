package fr.uphf.etu.flotte;

import fr.uphf.etu.exception.IdentifiantTransportDejaExistant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * Classe Java pour créer une Flotte
 * une liste de transport
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Flotte {
    private List<Transport> flotte = new ArrayList<>();

    /**
     * Coonstruteur vide
     */
    public Flotte() {
    }

    /**
     * Constructeur à une entrée
     *
     * @param flotte liste de transport
     */
    public Flotte(List<Transport> flotte) {
        this.flotte = flotte;
    }

    /**
     * Ajoute un transport donnée à la flotte
     *
     * @param transportAjouter transport à ajouter
     * @throws IdentifiantTransportDejaExistant deux identifiants identiques dans la flotte
     */
    public void ajouterTransport(Transport transportAjouter) throws IdentifiantTransportDejaExistant {
        for (Transport transport : this.flotte) {
            if(transportAjouter.getIdTransport() == transport.getIdTransport()) {
                throw new IdentifiantTransportDejaExistant("L'Id du Transport existe déjà : " + transportAjouter.getIdTransport());
            }
        }
        this.flotte.add(transportAjouter);
    }

    /**
     * Lire une flotte d'un fichier texte et l'ajoute
     *
     * @param cheminFichier chemin du Fichier texte
     */
    public void lireFlotte(String cheminFichier) {
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

                if(line.equals("barge"))
                {
                    Bateau nouvelleBarge = new Bateau(Integer.parseInt(mots[0]));
                    try {
                        ajouterTransport(nouvelleBarge);
                    } catch (IdentifiantTransportDejaExistant e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(line.equals("train"))
                {
                    Train nouveauTrain = new Train(Integer.parseInt(mots[0]));
                    try {
                        ajouterTransport(nouveauTrain);
                    } catch (IdentifiantTransportDejaExistant e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Camion nouveauCamion = new Camion(Integer.parseInt(mots[0]));
                    try {
                        ajouterTransport(nouveauCamion);
                    } catch (IdentifiantTransportDejaExistant e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Enregistre le flotte dans un fichier .txt
     * @param numeroTest numero du fichier
     */
    public void enregistrerFlotte(int numeroTest) {
        try {

            String contenu = "Numero\tType\tTaille\n";
            for (Transport transport : this.flotte) {
                contenu = contenu + transport.getIdTransport() + "\t" + transport.getClass().getSimpleName() + "\t" + transport.getTaille() + "\n";
            }

            File file = new File(numeroTest + "_flotte.txt");
            // créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenu);
            bw.close();

            System.out.println("Enregistrement réussi !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Supprime un transport donnée de la flotte
     *
     * @param transportSupprimer transport à supprimer
     */
    public void supprimerTransport(Transport transportSupprimer) {
        this.flotte.remove(transportSupprimer);
    }

    /**
     * Supprime l'ensemble des transports de la flotte
     */
    public void supprimerTout(){
       this.flotte.removeAll(flotte);

    }

    /**
     * Retourne la flotte
     *
     * @return la flotte
     */
    public List<Transport> getFlotte() {
        return flotte;
    }

    public void afficherFlotte() {
        flotte.forEach(
            f -> {
                if(f.getClass().getSimpleName().equals("Camion"))
                {
                    System.out.println(f.getIdTransport() + " " + "Camion");
                }
                else if(f.getClass().getSimpleName().equals("Train"))
                {
                    System.out.println(f.getIdTransport() + " " + "Train");
                }
                else
                {
                    System.out.println(f.getIdTransport() + " " + "Barge");
                }
            }
        );
    }


}
