/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservevehicule;

/**
 *
 * @author thyme
 */
public class Personne {
    private int matricule;
    private String nom;
    private String nTel;
    private Service monService;
    private String mdp;

    public Personne(int matricule, String nom, String nTel, Service monService, String mdp) {
        this.matricule = matricule;
        this.nom = nom;
        this.nTel = nTel;
        this.monService = monService;
        this.mdp = mdp;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getnTel() {
        return nTel;
    }

    public Service getMonService() {
        return monService;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setnTel(String nTel) {
        this.nTel = nTel;
    }

    public void setMonService(Service monService) {
        this.monService = monService;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
    
}
