package reservvehi;

import java.sql.*;

public class Authentification {

    public static boolean verifierConnexion(String matricule, String mdp) {
        Connection cn = Passerelle.getConnexion();
        boolean ok = false;
        try {
            String sql = "SELECT * FROM personne WHERE matricule = ? AND mdp = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, matricule);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Connexion réussie !");
                ok = true;
            } else {
                System.out.println("Matricule ou mot de passe incorrect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok;
    }
}
