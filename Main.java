package reservvehi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bienvenue dans l'application de réservation de véhicules ===");

        // --- Connexion utilisateur ---
        System.out.print("Matricule : ");
        int matricule = sc.nextInt();
        sc.nextLine(); // consomme le retour à la ligne

        System.out.print("Mot de passe : ");
        String mdp = sc.nextLine();

        if (!Passerelle.verifierConnexion(matricule, mdp)) {
            System.out.println("Accès refusé !");
            Passerelle.fermerConnexion();
            sc.close();
            return;
        }

        Personne utilisateur = Passerelle.getPersonneConnectee(matricule, mdp);
        System.out.println("Connexion réussie ! Bonjour " + utilisateur.getNom());

        // --- Menu ---
        boolean quitter = false;
        while (!quitter) {
            System.out.println("\n=== Menu Réservation Véhicules ===");
            System.out.println("1 - Ajouter une demande");
            System.out.println("2 - Afficher toutes les demandes");
            System.out.println("3 - Quitter");
            System.out.print("Choix : ");
            int choix = sc.nextInt();
            sc.nextLine(); // consomme le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Numéro type véhicule : ");
                    int noType = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Date début (jj/mm/aaaa) : ");
                    String dateDebut = sc.nextLine();

                    System.out.print("Durée (jours) : ");
                    int duree = sc.nextInt();
                    sc.nextLine();

                    Passerelle.ajouterDemande(utilisateur.getMatricule(), noType, dateDebut, duree);
                    break;

                case 2:
                    Passerelle.afficherDemandes();
                    break;

                case 3:
                    quitter = true;
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
        }

        Passerelle.fermerConnexion();
        sc.close();
        System.out.println("Au revoir !");
    }
}
