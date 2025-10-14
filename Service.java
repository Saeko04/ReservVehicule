/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservevehicule;

/**
 *
 * @author thyme
 */
public class Service {
    private int numero;
    private String libelle;

    public Service(int numero, String libelle) {
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
        return "Service{" + "numero=" + numero + ", libelle=" + libelle + '}';
    }
    
    
    
    
}
