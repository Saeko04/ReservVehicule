package reservvehi;

import java.util.Scanner;

public class TestConnexion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez votre matricule : ");
        int matricule = sc.nextInt();
        sc.nextLine(); // consomme le retour à la ligne

        System.out.print("Entrez votre mot de passe : ");
        String mdp = sc.nextLine();

        boolean ok = Passerelle.verifierConnexion(matricule, mdp);

        if (ok) {
            System.out.println(" :) Acces autorise !");
        } else {
            System.out.println(" :( Acces refuse !");
        }

        Passerelle.fermerConnexion();
    }
}
