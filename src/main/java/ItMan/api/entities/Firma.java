package ItMan.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "firma", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nip","regon"})
})
public class Firma {
    public Integer getIdFirmy() {
        return idFirmy;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Firmy")
    private Integer idFirmy;

    @Column(name = "nazwa", nullable = false, length = 100)
    private String nazwa;

    @Column(name = "nip", nullable = false, length = 10)
    private String nip;

    @Column(name = "regon", nullable = false, length = 15)
    private String regon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adres_id", referencedColumnName = "id_adres")
    Adres adres;

    @JsonIgnore
    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL)
    //@JoinColumn(name="idPasswords_ID", referencedColumnName = "idPasswords")
    private List<Haslo> passwords = new ArrayList<Haslo>();

    @JsonIgnore
    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL)
    //@JoinColumn(name="idPasswords_ID", referencedColumnName = "idPasswords")
    private List<Urzadzenie> urzadzenia = new ArrayList<Urzadzenie>();

    public Firma(){

    }

    public Firma(String nazwa, String nip, String regon, Adres adres){
        this.nazwa = nazwa;
        this.nip = nip;
        this.regon = regon;
        this.adres = adres;
    }

    public void setIdFirmy(Integer idFirmy) {
        this.idFirmy = idFirmy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<Haslo> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<Haslo> passwords) {
        this.passwords = passwords;
    }

    public List<Urzadzenie> getUrzadzenia() {
        return urzadzenia;
    }

    public void setUrzadzenia(List<Urzadzenie> urzadzenia) {
        this.urzadzenia = urzadzenia;
    }
}
