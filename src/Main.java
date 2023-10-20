package src;


import java.util.Scanner;

public class Main {
    static String fonctionName = "q";
    static String Value1 = null;
    static String Value2 = null;
    static int nbparam = 0;
    static int population = 10;
    static boolean ok = true;
    static Scanner scan = new Scanner(System.in);
    static UnionFind uf = new UnionFind(population);

    public static void main(String[] args) {
        Display.rules();

        while (ok) {
            String line = scan.nextLine();
            ParseLine(line);
            if (IsValueOK()) {
                WhichFunction();
            } else {
                Display.error_param();
            }
            scan.reset();
        }
    }

    private static void WhichFunction() {
        switch (fonctionName) {
            case "lier":
                if (nbparam == 2) {
                    uf.union(Integer.parseInt(Value1), Integer.parseInt(Value2));
                } else {
                    Display.error_nb_param();
                }
                break;

            case "isoler":
                if (nbparam == 1) {
                    uf.isolate(Integer.parseInt(Value1));
                } else {
                    Display.error_nb_param();
                }
                break;

            case "ami":
                if (nbparam == 2) {
                    uf.areFriends(Integer.parseInt(Value1), Integer.parseInt(Value2));
                } else {
                    Display.error_nb_param();
                }
                break;

            case "ajouter":
                if (nbparam == 0) {
                    uf.addElement();
                    population++;
                } else {
                    Display.error_nb_param();
                }
                break;

            case "q":
                if (nbparam == 0) {
                    System.out.println("Au Revoir");
                    ok = false;
                } else Display.error_nb_param();
                break;

            default:
                Display.error_fonction();
        }
    }

    public static void ParseLine(String line) {
        String[] parts = line.split(" ");
        nbparam = parts.length - 1;

        if (nbparam >= 0) {
            fonctionName = parts[0];
            if (nbparam >= 1) {
                Value1 = parts[1];
            }
            if (nbparam == 2) {
                Value2 = parts[2];
            }
        }
    }

    private static boolean IsValueOK() {
        return switch (nbparam) {
            case 0 -> true;
            case 1 -> isInteger(Value1);
            case 2 -> (isInteger(Value2) && isInteger(Value2));
            default -> false;
        };
    }

    private static boolean isInteger(String input) {
        //Pass in string
        try { //Try to make the input into an integer
            Integer.parseInt(input);
            return true; //Return true if it works
        } catch (Exception e) {
            return false; //If it doesn't work return false
        }
    }
}


