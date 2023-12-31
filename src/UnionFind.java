package src;

import java.util.ArrayList;

public class UnionFind {
    private ArrayList<Integer> peuple;

    public UnionFind(int n) {
        peuple = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            peuple.add(i);
        }
    }

    public int FindChef(int x) {
        return peuple.get(x);
    }


    // Fusionner les groupes
    public void union(int x, int y) {
        int ChefX = FindChef(x);
        int ChefY = FindChef(y);

        if (ChefX != ChefY) {
            if (ChefX < ChefY) {
                for (int i = ChefY; i < peuple.size(); i++) {
                    if (peuple.get(i) == ChefY) {
                        peuple.set(i, ChefX);
                    }
                }
            } else {
                for (int i = ChefX; i < peuple.size(); i++) {
                    if (peuple.get(i) == ChefX) {
                        peuple.set(i, ChefY);
                    }
                }
            }
        }
    }


    // Isoler un élément en le retirant de son groupe
    public void isolate(int x) {
        if (FindChef(x) != x) {
            peuple.set(x, x);
        } else {
            int FuturChefX = -1;
            for (int i = x+1; i < peuple.size(); i++) {
                if (peuple.get(i) == x) {
                    FuturChefX = i;
                    break;
                }
            }
            if (FuturChefX == -1) {
                return;
            }
            for (int i = FuturChefX+1; i < peuple.size(); i++) {
                if (peuple.get(i) == x) {
                    peuple.set(i, FuturChefX);
                }
            }
        }
    }

    // Ajouter une personne
    public void addElement() {
        peuple.add(peuple.size());
    }

    public boolean areFriends(int x, int y) {
        return FindChef(x) == FindChef(y);
    }
}