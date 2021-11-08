package fr.uphf.etu.structure;

import fr.uphf.etu.exception.IdentifiantTransportDejaExistant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
}
