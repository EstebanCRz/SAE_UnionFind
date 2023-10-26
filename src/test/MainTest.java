package src.test;


import src.*;

import java.util.Random;
import java.util.Scanner;

public class MainTest {
    static Random r = new Random();
    static String fonctionName = "q";
    static String valeur1 = null;
    static String valeur2 = null;
    static int nbparam = 0;
    static int population = 1;
    static boolean ok = true;
    static Scanner scan = new Scanner(System.in);
    static UnionFind uf = new UnionFind(population);

    public static void main(String[] args) {
        Display.rulestest();

        while (ok) {
            String line = scan.nextLine();
            ParseLine(line);
            if (ValidParameters()) {
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
                if (nbparam == 1) {
                    int iterations = Integer.parseInt(valeur1);
                    long d = System.nanoTime();
                    for (int i = 0; i < iterations-1; i++) {
                        uf.union(r.nextInt((iterations) + 1), r.nextInt((iterations) + 1));
                        //random prend 0.0036 microsecondes par itération
                        //soit 0.36 millisecondes pour 100 000 itérations
                    }
                    long f = System.nanoTime();
                    long t = f-d;
                    System.out.println(t/1_000_000+" microsecondes");

                } else {
                    Display.error_nb_param();
                }
                break;

            case "isoler":
                if (nbparam == 1) {
                    int iterations = Integer.parseInt(valeur1);
                    long d = System.nanoTime();
                    for (int i = 0; i < iterations; i++) {
                        uf.isolate(r.nextInt((iterations) + 1));
                        //random prend 0.0036 microsecondes par itération
                        //soit 0.36 millisecondes pour 100 000 itérations
                    }
                    long f = System.nanoTime();
                    long t = f-d;
                    System.out.println(t/1_000_000+" microsecondes");
                } else {
                    Display.error_nb_param();
                }
                break;

            case "ami":
                if (nbparam == 2) {
                    uf.areFriends(Integer.parseInt(valeur1), Integer.parseInt(valeur2));
                } else {
                    Display.error_nb_param();
                }
                break;

            case "ajouter":
                if (nbparam == 1) {
                    long d = System.nanoTime();
                    int iterations = Integer.parseInt(valeur1);
                    for (int i = 0; i < iterations; i++) {
                        uf.addElement();
                    }
                    long f = System.nanoTime();
                    long t = f-d;
                    System.out.println(t/1_000_000+" microsecondes");
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
                valeur1 = parts[1];
            }
            if (nbparam == 2) {
                valeur2 = parts[2];
            }
        }
    }

    private static boolean ValidParameters() {
        return switch (nbparam) {
            case 0 -> true;
            case 1 -> isInteger(valeur1);
            case 2 -> isInteger(valeur1) && isInteger((valeur2));
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


