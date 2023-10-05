import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean ok = true;
        boolean BonNum = true;
        String fonctionName = null;
        String ami1 = null;
        String ami2 = null;
        int nbparam = 0;
        int population = 10;
        UnionFind uf = new UnionFind(population);

        System.out.println("Pour ajouter une personne :    \"ajouter\"");
        System.out.println("Pour lier des amis :           \"lier valeurs1 valeurs2\"");
        System.out.println("Pour isoler une personne :     \"isoler valeurs1\"");
        System.out.println("Pour savoir si ils sont amis : \"ami valeurs1 valeurs2\"");
        System.out.println("Pour quitter :                 \"q\"");

        Scanner scan = new Scanner(System.in);

        while (ok) {
            String line = scan.nextLine();
            String[] parts = line.split(" ");

            if (parts.length > 0) {
                fonctionName = parts[0];
                nbparam = parts.length - 1;
                if (nbparam >= 1) {
                    ami1 = parts[1];
                    if (!isInteger(ami1)) {
                        BonNum = false;
                    }
                }
                if (nbparam == 2) {
                    ami2 = parts[2];
                    if (!isInteger(ami2)) {
                        BonNum = false;
                    }
                }
            }

            if (BonNum){
                switch (fonctionName) {
                    case "lier":
                        if (nbparam==2) {
                            uf.union(Integer.parseInt(ami1), Integer.parseInt(ami2));
                        }
                        else BonNum = false;
                        break;

                    case "isoler":
                        if (nbparam==1) {
                            uf.isolate(Integer.parseInt(ami1));
                        }
                        else BonNum = false;
                        break;

                    case "ami":
                        if (nbparam==2) {
                            uf.areFriends(Integer.parseInt(ami1), Integer.parseInt(ami2));
                        }
                        else BonNum = false;
                        break;

                    case "ajouter":
                        if (nbparam==2) {
                            uf.addElement();
                            population++;
                        }
                        else BonNum = false;
                        break;

                    case "q":
                        if (nbparam==0) {
                            System.out.println("Au Revoir");
                            ok = false;
                        }
                        break;

                    default:
                        System.out.println("vous avez mal écrit la fonction");
                }
            }
            if (!BonNum) {
                System.out.println("vous avez mal écrit les paramètres");
                BonNum = true;
                scan.nextLine();
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


