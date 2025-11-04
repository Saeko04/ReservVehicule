package reservvehi;

/**
 *
 * @author thyme
 */
public class Type {
    private int numero;
    private String libelle;

    public Type(int numero, String libelle) {
        this.numero = numero;
        this.libelle = libelle;
    }

    public int getNumero() {
        return numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Type{" + "numero=" + numero + ", libelle=" + libelle + '}';
    }
}
