package src;

import java.util.ArrayList;

public class UnionFind {
    private ArrayList<Integer> Nation;

    public UnionFind(int n) {
        Nation = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Nation.add(i);
        }
    }

    public int FindChef(int x) {
        return Nation.get(x);
    }
    

    // Fusionner les groupes
    public void union(int x, int y) {
        int ChefX = FindChef(x);
        int ChefY = FindChef(y);

        if (ChefX != ChefY) {
            if (ChefX < ChefY) {
                for (int i = ChefY; i < Nation.size(); i++) {
                    if (Nation.get(i) == ChefY) {
                        Nation.set(i, ChefX);
                    }
                }
            } else {
                for (int i = ChefX; i < Nation.size(); i++) {
                    if (Nation.get(i) == ChefX) {
                        Nation.set(i, ChefY);
                    }
                }
            }
        }
    }


    // Isoler un élément en le retirant de son groupe
    public void isolate(int x) {
        if (FindChef(x) != x) {
            Nation.set(x, x);
        } else {
            int FuturChefX = -1;
            for (int i = x+1; i < Nation.size(); i++) {
                if (Nation.get(i) == x) {
                    FuturChefX = i;
                    break;
                }
            }
            if (FuturChefX == -1) {
                return;
            }
            for (int i = FuturChefX; i < Nation.size(); i++) {
                if (Nation.get(i) == x) {
                    Nation.set(i, FuturChefX);
                }
            }
        }
    }

    // Ajouter une personne
    public void addElement() {
        Nation.add(Nation.size());
    }
    public void areFriends(int x, int y) {
        if (FindChef(x) == FindChef(y)) {
            Display.friend(x, y);
        } else {
            Display.Notfriend(x, y);
        }
    }
}