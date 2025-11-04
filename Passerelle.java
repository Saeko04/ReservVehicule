package reservvehi;

import java.sql.*;

public class Passerelle {

    private static Connection connexion = null;

    public static Connection getConnexion() {
        if (connexion == null) {
            try {
                Class.forName("org.postgresql.Driver");

                String url = "jdbc:postgresql://192.168.1.245:5432/slam2026_AP_louisethymeo?useUnicode=true&characterEncoding=UTF-8";
                String user = "lemay";
                String password = "lemay";

                connexion = DriverManager.getConnection(url, user, password);
                System.out.println("Connexion réussie à PostgreSQL !");
            } catch (ClassNotFoundException e) {
                System.out.println("Pilote PostgreSQL non trouvé !");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Erreur de connexion à la base !");
                e.printStackTrace();
            }
        }
        return connexion;
    }

    public static void fermerConnexion() {
        if (connexion != null) {
            try {
                connexion.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean verifierConnexion(int matricule, String mdp) {
        boolean valide = false;
        try {
            String sql = "SELECT * FROM personne WHERE matricule=? AND mdp=?";
            PreparedStatement ps = getConnexion().prepareStatement(sql);
            ps.setInt(1, matricule);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valide = true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valide;
    }

    public static Personne getPersonneConnectee(int matricule, String mdp) {
        Personne p = null;
        try {
            String sql = "SELECT * FROM personne WHERE matricule=? AND mdp=?";
            PreparedStatement ps = getConnexion().prepareStatement(sql);
            ps.setInt(1, matricule);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Personne(rs.getInt("matricule"),
                        rs.getString("nom"),
                        rs.getString("telephone"),
                        null,
                        rs.getString("mdp"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static void afficherDemandes() {
        try {
            String sql = "SELECT * FROM demande";
            PreparedStatement ps = getConnexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Liste des demandes =====");
            while (rs.next()) {
                System.out.println("Numéro : " + rs.getInt("numero")
                        + " | Matricule : " + rs.getInt("matricule")
                        + " | Type : " + rs.getInt("notype")
                        + " | Immat : " + rs.getString("immat")
                        + " | Date début : " + rs.getDate("datedebut")
                        + " | Durée : " + rs.getInt("duree")
                        + " | État : " + rs.getString("etat"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ajouterDemande(int matricule, int noType, String dateDebut, int duree) {
        try {
            // Conversion jj/MM/yyyy → yyyy-MM-dd
            String[] parts = dateDebut.split("[/\\-]");
            if (parts.length != 3) {
                System.out.println("Format de date invalide !");
                return;
            }
            String dateSQL = parts[2] + "-" + parts[1] + "-" + parts[0];

            String sql = "INSERT INTO demande (datereserv, numero, datedebut, matricule, notype, duree, etat) "
                    + "VALUES (CURRENT_DATE, DEFAULT, ?, ?, ?, ?, 'demandée')";
            PreparedStatement ps = getConnexion().prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(dateSQL));
            ps.setInt(2, matricule);
            ps.setInt(3, noType);
            ps.setInt(4, duree);

            int nb = ps.executeUpdate();
            if (nb > 0) {
                System.out.println("✅ Demande ajoutée avec succès !");
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
