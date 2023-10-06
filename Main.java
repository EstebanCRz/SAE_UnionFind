import java.util.Scanner;


public class Main {
    static String fonctionName = "q";
    static String ami1 = null;
    static String ami2 = null;
    static int nbparam = 0;
    static boolean ok = true;
    static boolean BonNum = true;
    static int population = 10;

    static UnionFind uf = new UnionFind(population);

    public static void main(String[] args) {
        boolean ok = true;
        boolean BonNum = true;
        Affichage.regle();
        Scanner scan = new Scanner(System.in);

        while (ok) {
            String line = scan.nextLine();
            separer_valeur(line);
            if (BonNum){
                quel_fonction();
            }
            if (!BonNum) {
                Affichage.erreur_param();
                BonNum = true;
                scan.nextLine();
            }
        }
    }

    private static void quel_fonction() {
        switch (fonctionName) {
            case "lier":
                if (nbparam==2) {
                    uf.union(Integer.parseInt(ami1), Integer.parseInt(ami2));
                }
                else {
                    BonNum = false;
                    Affichage.erreur_nb_param();
                }
                break;

            case "isoler":
                if (nbparam==1) {
                    uf.isolate(Integer.parseInt(ami1));
                }
                else {
                    BonNum = false;
                    Affichage.erreur_nb_param();
                }
                break;

            case "ami":
                if (nbparam==2) {
                    uf.areFriends(Integer.parseInt(ami1), Integer.parseInt(ami2));
                }
                else {
                    BonNum = false;
                    Affichage.erreur_nb_param();
                }
                break;

            case "ajouter":
                if (nbparam==0) {
                    uf.addElement();
                    population++;
                }
                else {
                    BonNum = false;
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

    private static void separer_valeur(String line) {
        String[] parts = line.split(" ");

        if (parts.length > 0) {
            fonctionName = parts[0];
            nbparam = parts.length - 1;
            if (nbparam >= 1) {
                ami1 = parts[1];
                if (!isInteger(ami1)) {
                    Affichage.erreur_param();
                    BonNum = false;
                }
            }
            if (nbparam == 2) {
                ami2 = parts[2];
                if (!isInteger(ami2)) {
                    Affichage.erreur_param();
                    BonNum = false;
                }
            }
        }
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


