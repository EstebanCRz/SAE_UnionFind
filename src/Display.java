package src;
public class Display {
    public static void error_param() {
        System.out.println("Vous avez mal écrit les paramètres");
    }

    public static void error_nb_param() {
        System.out.println("Vous avez mal écrit les paramètres");
    }

    public static void error_fonction() {
        System.out.println("Vous avez mal écrit les paramètres");
    }

    public static void rules() {
        System.out.println("Pour afficher cette aide :     \"help\"");
        System.out.println("Pour ajouter une personne :    \"ajouter\"");
        System.out.println("Pour lier des amis :           \"lier valeur1 valeur2\"");
        System.out.println("Pour isoler une personne :     \"isoler valeur1\"");
        System.out.println("Pour savoir si ils sont amis : \"ami valeur1 valeur2\"");
        System.out.println("Pour quitter :                 \"exit\"");
    }

    public static void rulestest() {
        System.out.println("Pour tester une fonction veuillez mettre le nom de la fonction et le nombre d'itérations");
        System.out.println("Pour afficher cette aide :     \"help\"");
        System.out.println("Pour lier :                    \"lier valeur1\"");
        System.out.println("Pour isoler :                  \"isoler valeur1\"");
        System.out.println("Pour savoir si ils sont amis : \"ami valeur1\"");
        System.out.println("Pour quitter :                 \"exit\"");
    }

    public static void NotFriends(int x, int y) {
        System.out.println("Non, "+x+" et "+y+" ne sont pas amis.");
    }

    public static void Friends(int x, int y) {
        System.out.println("Oui, "+x+" et "+y+" sont des amis.");
    }
}
