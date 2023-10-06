import java.util.Scanner;


public class Main {
    static String fonctionName = "q";
    static String ami1 = null;
    static String ami2 = null;
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
            if (valeurOK(nbparam)) {
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
                    uf.union(Integer.parseInt(ami1), Integer.parseInt(ami2));
                }
                else {
                    Affichage.erreur_nb_param();
                    scan.nextLine();
                }
                break;

            case "isoler":
                if (nbparam==1) {
                    uf.isolate(Integer.parseInt(ami1));
                }
                else {
                    Affichage.erreur_nb_param();
                    scan.nextLine();
                }
                break;

            case "ami":
                if (nbparam==2) {
                    uf.areFriends(Integer.parseInt(ami1), Integer.parseInt(ami2));
                }
                else {
                    Affichage.erreur_nb_param();
                    scan.nextLine();
                }
                break;

            case "ajouter":
                if (nbparam==0) {
                    uf.addElement();
                    population++;
                }
                else {
                    Affichage.erreur_nb_param();
                    scan.nextLine();
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

    private static void separer_valeur(String line) {
        String[] parts = line.split(" ");
        nbparam = parts.length - 1;

        if (nbparam >= 0) {
            fonctionName = parts[0];
            if (nbparam >= 1) {
                ami1 = parts[1];
            }
            if (nbparam == 2) {
                ami2 = parts[2];
            }
        }
    }

    private static boolean valeurOK(int nbparam){
        return switch (nbparam) {
            case 0 -> true;
            case 1 -> isInteger(ami1);
            case 2 -> isInteger(ami2);
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


