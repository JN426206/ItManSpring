package ItMan.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "adres")
public class Adres {

    public Adres() {

    }

    public Adres(String ulica, String kodPocztowy, String nrBudynku, String miasto) {
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.nrBudynku = nrBudynku;
        this.miasto = miasto;
    }

    public Adres(String ulica, String kodPocztowy, String nrBudynku, String miasto, String telefon) {
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.nrBudynku = nrBudynku;
        this.miasto = miasto;
        this.telefon = telefon;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Adres")
    private int idAdres;

    @Column(name = "ulica", nullable = false, length = 30)
    private String ulica;

    @Column(name = "kodpocztowy", nullable = false, length = 6)
    private String kodPocztowy;

    @Column(name = "nrbudynku", nullable = false, length = 10)
    private String nrBudynku;

    @Column(name = "miasto", nullable = false, length = 30)
    private String miasto;

    @Column(name = "telefon", length = 10)
    private String telefon;


    public int getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(int idAdres) {
        this.idAdres = idAdres;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(String nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
