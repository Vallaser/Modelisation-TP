package fr.uphf.etu.structure;

import fr.uphf.etu.exception.IdentifiantTransportDejaExistant;

/**
 *
 * Classe Java pour lancer des tests
 *
 *
 * @author  Valérian BAL
 * @version 1.0
 *
 **/
public class Main {
    public static void main(String[] args) {

        Flotte flotte = new Flotte();

        Camion c1 = new Camion(50);
        System.out.println("Bateau Test 1 :");
        System.out.println(c1.getIdTransport());
        System.out.println(c1.getTaille());

        Camion c2 = new Camion(50);
        System.out.println("\nBateau Test 2 :");
        System.out.println(c2.getIdTransport());
        System.out.println(c2.getTaille());

        try {
            flotte.ajouterTransport(c1);
        }
        catch(IdentifiantTransportDejaExistant e) {
            e.printStackTrace();
        }

        try {
            flotte.ajouterTransport(c2);
        }
        catch(IdentifiantTransportDejaExistant e) {
            e.printStackTrace();
        }

        flotte.enregistrerFlotte(1);

        //System.out.println(flotte.getFlotte().get(0).getIdTransport());
    }
}
