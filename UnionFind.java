import java.util.Arrays;

public class UnionFind {
    private int[] ami;

    public UnionFind(int n) {
        ami = new int[n];
        for (int i = 0; i < n; i++) {
            ami[i] = i;
        }
    }

    public int TrouverChef(int x) {
        return ami[x];
    }

    // Fusionner les groupes
    public void union(int x, int y) {
        int ChefX = TrouverChef(x);
        int ChefY = TrouverChef(y);

        if (ChefX != ChefY) {
            if (ChefX > ChefY) {
                for (int i = ChefY; i < ami.length - 1; i++) {
                    if (ami[i] == ChefY) {
                        ami[i] = ChefX;
                    }
                }
            } else{
                for (int i = ChefY; i < ami.length - 1; i++) {
                    if (ami[i] == ChefY) {
                        ami[i] = ChefX;
                    }
                }
            }
        }
    }

    // Isoler un élément en le retirant de son groupe
    public void isolate(int x) {
        int FuturChefX = x;
        int ChefX = TrouverChef(x);
        if (ChefX == x){
            //il est chef alors on cherche le futur chef
            for (int i = x+1; i < ami.length-1; i++) {
                if (ami[i] == x) {
                    FuturChefX = ami[i];
                    break;
                }
            }
            //on ajoute futurchefX au ancien amis de x
            for (int i = FuturChefX+1; i < ami.length-1; i++) {
                if (ami[i] == x) {
                    ami[i] = FuturChefX;
                }
            }
        }
        else{
            ami[x] = x;
        }
    }

    // Ajouter une personne
    public void addElement() {
        int n = ami.length;
        ami = Arrays.copyOf(ami, n + 1);
        ami[n] = n;
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