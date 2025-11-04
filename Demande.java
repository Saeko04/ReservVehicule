package reservvehi;

import java.util.Date;

/**
 *
 * @author thyme
 */
public class Demande {
    private Date dateReserv;
    private int numero;
    private Date dateDebut;
    private Personne leMatricule;
    private Type leType;
    private Vehicule LImat;
    private int duree;
    private Date dateretoureffectif;
    private Boolean etat;

    public Demande(Date dateReserv, int numero, Date dateDebut, Personne leMatricule, Type leType, Vehicule LImat, int duree, Date dateretoureffectif, Boolean etat) {
        this.dateReserv = dateReserv;
        this.numero = numero;
        this.dateDebut = dateDebut;
        this.leMatricule = leMatricule;
        this.leType = leType;
        this.LImat = LImat;
        this.duree = duree;
        this.dateretoureffectif = dateretoureffectif;
        this.etat = etat;
    }

    public Date getDateReserv() {
        return dateReserv;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Personne getLeMatricule() {
        return leMatricule;
    }

    public Type getLeType() {
        return leType;
    }

    public Vehicule getLImat() {
        return LImat;
    }

    public int getDuree() {
        return duree;
    }

    public Date getDateretoureffectif() {
        return dateretoureffectif;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setDateReserv(Date dateReserv) {
        this.dateReserv = dateReserv;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setLeMatricule(Personne leMatricule) {
        this.leMatricule = leMatricule;
    }

    public void setLeType(Type leType) {
        this.leType = leType;
    }

    public void setLImat(Vehicule LImat) {
        this.LImat = LImat;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setDateretoureffectif(Date dateretoureffectif) {
        this.dateretoureffectif = dateretoureffectif;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
    
}
