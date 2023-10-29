package src.test;

import src.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainTest {

    static Random r = new Random();

    private final static int FUNCTION = 0;
    private final static int VALUE1 = 1;
    private final static int VALUE2 = 2;

    static int population_size = 1_000;
    static boolean running = true;
    static Scanner scan = new Scanner(System.in);
    static UnionFind uf = new UnionFind(population_size);

    public static void main(String[] args) {
        Display.rulestest();

        while (running) {
            String line = scan.nextLine();
            ArrayList<String> argslist = ParseLine(line);
            if (ValidParameters(argslist)) {
                WhichFunction(argslist);
            } else {
                Display.error_param();
            }
            scan.reset();
        }
    }

    private static void WhichFunction(ArrayList<String> args) {
        switch (args.get(FUNCTION)) {
            case "lier":
                if (args.size() == 2) {
                    int iterations = Integer.parseInt(args.get(VALUE1));
                    long d = System.nanoTime();
                    for (int i = 0; i < iterations-1; i++) {
                        uf.union(r.nextInt(population_size), r.nextInt(population_size));
                        //random prend 0.0036 microsecondes par itération
                        //soit 0.36 millisecondes pour 100 000 itérations
                    }
                    long f = System.nanoTime();
                    long t = f-d;
                    System.out.println(t/1_000_000+" millisecondes");

                } else {
                    Display.error_nb_param();
                }
                break;

            case "isoler":
                if (args.size() == 2) {
                    int iterations = Integer.parseInt(args.get(VALUE1));
                    long d = System.nanoTime();
                    for (int i = 0; i < iterations; i++) {
                        uf.isolate(r.nextInt(population_size));
                        //random prend 0.0036 microsecondes par itération
                        //soit 0.36 millisecondes pour 100 000 itérations
                    }
                    long f = System.nanoTime();
                    long t = f-d;
                    System.out.println(t/1_000_000+" millisecondes");
                } else {
                    Display.error_nb_param();
                }
                break;

            case "ami":
                if (args.size() == 3) {
                    int x = Integer.parseInt(args.get(VALUE1));
                    int y =Integer.parseInt(args.get(VALUE2));
                    if(uf.areFriends(x,y)) {
                        Display.Friends(x, y);
                    }
                    Display.NotFriends(x, y);
                } else {
                    Display.error_nb_param();
                }
                break;
            case "ajouter":
                if (args.size() == 2) {
                    long d = System.nanoTime();
                    int iterations = Integer.parseInt(args.get(VALUE1));
                    for (int i = 0; i < iterations; i++) {
                        uf.addElement();
                    }
                    long f = System.nanoTime();
                    long t = f-d;
                    System.out.println(t/1_000_000+" millisecondes");
                } else {
                    Display.error_nb_param();
                }
                break;
            case "help":
                Display.rulestest();
                break;
            case "exit":
                if (args.size() == 1) {
                    System.out.println("Au Revoir");
                    running = false;
                } else Display.error_nb_param();
                break;

            default:
                Display.error_fonction();
        }
    }

    public static ArrayList<String> ParseLine(String line) {
        String[] words = line.split(" ");

        //renvoie une array list avec pour chaque valeur un mot
        return new ArrayList<String>(Arrays.asList(words));

    }

    private static boolean ValidParameters(ArrayList<String> args) {
        return switch (args.size()) {
            case 1 -> true;
            case 2 -> isInteger(args.get(VALUE1));
            case 3 -> (isInteger(args.get(VALUE1)) && isInteger(args.get(VALUE2)));
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


