package reservvehi;
/**
 *
 * @author Louise
 */
import modele.ConnexionPostgres;
import java.sql.Connection;

public class TestConnexion {

    public static void main(String[] args) {
        Connection conn = ConnexionPostgres.getConnexion();
        ConnexionPostgres.fermerConnexion();
    }
}
