package reservvehi;

/**
 *
 * @author Louise
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionPostgres {

    private static Connection connexion = null;

    public static Connection getConnexion() {
        if (connexion == null) {
            try {
                // Charger le pilote
                Class.forName("org.postgresql.Driver");

                // Modifier les infos selon ta config
                String url = "jdbc:postgresql://192.168.1.245:5432/slam2026_AP_louisethymeo";
                String user = "lemay";
                String password = "lemay";

                connexion = DriverManager.getConnection(url, user, password);
                System.out.println("Connexion reussie a PostgreSQL !");
            } catch (ClassNotFoundException e) {
                System.out.println("Pilote PostgreSQL non trouve !");
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
                System.out.println("Connexion fermee.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
