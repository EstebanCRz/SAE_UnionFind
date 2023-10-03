import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean ok = true;
        int ami1;
        int ami2;
        int population = 10;
        UnionFind uf = new UnionFind(population);

        System.out.println("Pour ajouter une personne :\"ajouter\"");
        System.out.println("Pour lier des amis :\"lier valeurs1 valeurs2\"");
        System.out.println("Pour isoler une personne :\"isoler valeurs1\"");
        System.out.println("Pour savoir si ils sont amis :\"ami valeurs1 valeurs2\"");
        System.out.println("Pour quitter :\"q\"");

        Scanner scan = new Scanner(System.in);


        while(ok) {
            String fonctionName = scan.next();
            //recupere la fonction

            switch (fonctionName) {
                case "lier":
                    ami1 = Integer.parseInt(scan.next());
                    ami2 = Integer.parseInt(scan.next());
                    uf.union(ami1, ami2);
                    break;

                case "isoler":
                    ami1 = Integer.parseInt(scan.next());
                    uf.isolate(ami1);
                    break;

                case "ami":
                    ami1 = Integer.parseInt(scan.next());
                    ami2 = Integer.parseInt(scan.next());
                    uf.areFriends(ami1, ami2);
                    break;

                case "ajouter":
                    uf.addElement();
                    break;

                case "q":
                    ok = false;
                    break;

                default:
                    System.out.println("vous avez mal écrit");
                    break;
            }
        }
    }
}
