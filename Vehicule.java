package reservvehi;

/**
 *
 * @author thyme
 */
public class Vehicule {
    private String immat;
    private String marque;
    private String modele;
    private Type leType;

    public Vehicule(String immat, String marque, String modele, Type noType) {
        this.immat = immat;
        this.marque = marque;
        this.modele = modele;
        this.leType = leType;
    }

    public String getImmat() {
        return immat;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public Type getLeType() {
        return leType;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setLeType(Type leType) {
        this.leType = leType;
    }
    
}
