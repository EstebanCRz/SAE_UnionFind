package src;

import java.util.Arrays;

public class UnionFind {
    private int[] peuple;

    public UnionFind(int n) {
        peuple = new int[n];
        for (int i = 0; i < n; i++) {
            peuple[i] = i;
        }
    }

    public int TrouverChef(int x) {
        return peuple[x];
    }

    // Fusionner les groupes
    public void union(int x, int y) {
        int ChefX = TrouverChef(x);
        int ChefY = TrouverChef(y);

        if (ChefX != ChefY) {
            if (ChefX < ChefY) {
                for (int i = ChefY; i < peuple.length - 1; i++) {
                    if (peuple[i] == ChefY) {
                        peuple[i] = ChefX;
                    }
                }
            } else{
                for (int i = ChefX; i < peuple.length - 1; i++) {
                    if (peuple[i] == ChefX) {
                        peuple[i] = ChefY;
                    }
                }
            }
        }
    }

    // Isoler un élément en le retirant de son groupe
    public void isolate(int x) {
        if (TrouverChef(x) != x){
            peuple[x] = x;
        }
        else {
            int FuturChefX = -1;
            //il est chef alors on cherche le futur chef
            for (int i = x+1; i < peuple.length-1; i++) {
                if (peuple[i] == x) {
                    FuturChefX = i;
                    break;
                }
            }
            if (FuturChefX == -1){
                //il est son seul ami
                return;
            }
            //on ajoute futurchefX au ancien amis de x
            for (int i = FuturChefX; i < peuple.length-1; i++) {
                if (peuple[i] == x) {
                    peuple[i] = FuturChefX;
                }
            }
        }
    }

    // Ajouter une personne
    public void addElement() {
        int n = peuple.length;
        peuple = Arrays.copyOf(peuple, n + 1);
        peuple[n] = n;
    }

    public void areFriends(int x, int y) {
        if (TrouverChef(x) == TrouverChef(y)){
            System.out.println(x +" and "+ y +" are friends");
        }
        else{
            System.out.println(x +" and "+ y +" are not friends");
        }
    }
}