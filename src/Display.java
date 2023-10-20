package src;

public class Display {
    public static void error_param() {
        System.out.println("vous avez mal écrit les paramètres");
    }

    public static void error_nb_param() {
        System.out.println("vous avez mal écrit les paramètres");
    }

    public static void error_fonction() {
        System.out.println("vous avez mal écrit les paramètres");
    }

    public static void rules() {
        System.out.println("Pour ajouter une personne :    \"ajouter\"");
        System.out.println("Pour lier des amis :           \"lier valeurs1 valeurs2\"");
        System.out.println("Pour isoler une personne :     \"isoler valeurs1\"");
        System.out.println("Pour savoir si ils sont amis : \"ami valeurs1 valeurs2\"");
        System.out.println("Pour quitter :                 \"q\"");
    }

    public static void rulestest() {
        System.out.println("Pour tester un fonction veuillez mettre le nom de la fonction et le nombre d'itération");
        System.out.println("Pour lier :                    \"lier valeurs1\"");
        System.out.println("Pour isoler :                  \"isoler valeurs1\"");
        System.out.println("Pour savoir si ils sont amis : \"ami valeurs1\"");
        System.out.println("Pour quitter :                 \"q\"");
    }

    public static void Notfriend(int x, int y) {
        System.out.println("Non "+x+" et "+y+" ne sont pas amis");
    }
    public static void friend(int x, int y) {
        System.out.println("Oui "+x+" et "+y+" sont des amis");
    }
}
