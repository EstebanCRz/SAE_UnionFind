package src;

import src.Affichage;
import java.util.Scanner;


public class Main {
    static String fonctionName = "q";
    static String valeur1 = null;
    static String valeur2 = null;
    static int nbparam = 0;
    static int population = 10;
    static boolean ok = true;
    static Scanner scan = new Scanner(System.in);
    static UnionFind uf = new UnionFind(population);

    public static void main(String[] args) {
        Affichage.regle();

        while (ok) {
            String line = scan.nextLine();
            separer_valeur(line);
            if (valeurOK()) {
                quel_fonction();
            }
            else{
                Affichage.erreur_param();
            }
            scan.reset();
        }
    }
    private static void quel_fonction() {
        switch (fonctionName) {
            case "lier":
                if (nbparam==2) {
                    uf.union(Integer.parseInt(valeur1), Integer.parseInt(valeur2));
                }
                else {
                    Affichage.erreur_nb_param();
                }
                break;

            case "isoler":
                if (nbparam==1) {
                    uf.isolate(Integer.parseInt(valeur1));
                }
                else {
                    Affichage.erreur_nb_param();
                }
                break;

            case "ami":
                if (nbparam==2) {
                    uf.areFriends(Integer.parseInt(valeur1), Integer.parseInt(valeur2));
                }
                else {
                    Affichage.erreur_nb_param();
                }
                break;

            case "ajouter":
                if (nbparam==0) {
                    uf.addElement();
                    population++;
                }
                else {
                    Affichage.erreur_nb_param();
                }
                break;

            case "q":
                if (nbparam==0) {
                    System.out.println("Au Revoir");
                    ok = false;
                }
                else Affichage.erreur_nb_param();
                break;

            default:
                Affichage.erreur_fonction();
        }
    }

    public static void separer_valeur(String line) {
        String[] parts = line.split(" ");
        nbparam = parts.length - 1;

        if (nbparam >= 0) {
            fonctionName = parts[0];
            if (nbparam >= 1) {
                valeur1 = parts[1];
            }
            if (nbparam == 2) {
                valeur2 = parts[2];
            }
        }
    }

    private static boolean valeurOK(){
        return switch (nbparam) {
            case 0 -> true;
            case 1 -> isInteger(valeur1);
            case 2 -> (isInteger(valeur2) && isInteger(valeur2));
            default -> false;
        };
    }

    private static boolean isInteger(String input) {
        //Pass in string
        try { //Try to make the input into an integer
            Integer.parseInt( input );
            return true; //Return true if it works
        }
        catch( Exception e ) {
            return false; //If it doesn't work return false
        }
    }
}


