package ItMan.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "haslo")
public class Haslo {

    public Haslo() {

    }

    public Haslo(String nazwa, String haslo, DateTime dataUtworzenia, Firma firma, String opis){
        this.nazwa = nazwa;
        this.haslo = haslo;
        this.opis = opis;
        this.dataUtworzenia = dataUtworzenia;
        this.firma = firma;
    }

    public Haslo(String nazwa, String haslo, DateTime dataUtworzenia, Firma firma){
        this.nazwa = nazwa;
        this.haslo = haslo;
        this.dataUtworzenia = dataUtworzenia;
        this.firma = firma;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_Hasla")
    private int idHasla;

    @Column(name = "haslo", nullable = false, length = 100)
    private String haslo;

    @Column(name = "nazwa", nullable = false, length = 50)
    private String nazwa;

    @Column(name = "opis", length = 1000)
    private String opis;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "data_Utworzenia", nullable = false)
    private DateTime dataUtworzenia;

    @ManyToOne
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;


    public int getIdHasla() {
        return idHasla;
    }

    public void setIdHasla(int idPasswords) {
        this.idHasla = idPasswords;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String password) {
        this.haslo = password;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String name) {
        this.nazwa = name;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String comment) {
        this.opis = comment;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public DateTime getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(DateTime dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }
}
