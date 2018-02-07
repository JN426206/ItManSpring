package ItMan.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import ItMan.api.ParseDeserializer;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "urzadzenie")
public class Urzadzenie {

    public Urzadzenie() {}

    public Urzadzenie(String nazwa, String rodzaj, String status, String producent, String model, String nrSeryjny, DateTime dataUtworzenia, Firma firma){
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.status = status;
        this.producent = producent;
        this.model = model;
        this.nrSeryjny = nrSeryjny;
        this.dataUtworzenia = dataUtworzenia;
        this.firma = firma;
    }

    public Urzadzenie(String nazwa, String rodzaj, String status, String producent, String model, String nrSeryjny, DateTime dataUtworzenia, Firma firma, String systemOperacyjny){
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.status = status;
        this.producent = producent;
        this.model = model;
        this.nrSeryjny = nrSeryjny;
        this.dataUtworzenia = dataUtworzenia;
        this.firma = firma;
        this.systemOperacyjny = systemOperacyjny;
    }

    public Urzadzenie(String nazwa, String rodzaj, String status, String producent, String model, String nrSeryjny, DateTime dataUtworzenia, Firma firma, String systemOperacyjny, String opis){
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.status = status;
        this.producent = producent;
        this.model = model;
        this.nrSeryjny = nrSeryjny;
        this.dataUtworzenia = dataUtworzenia;
        this.firma = firma;
        this.systemOperacyjny = systemOperacyjny;
        this.opis = opis;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_Urzadzenia")
    private int idUrzadzenia;

    @Column(name = "nazwa", nullable = false, length = 50)
    private String nazwa;

    @Column(name = "rodzaj", nullable = false, length = 20)
    private String rodzaj;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "producent", nullable = false, length = 30)
    private String producent;

    @Column(name = "model", nullable = false, length = 30)
    private String model;

    @Column(name = "nr_Seryjny", nullable = false, length = 150)
    private String nrSeryjny;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = ParseDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "data_Utworzenia", nullable = false)
    private DateTime dataUtworzenia;

    @Column(name = "system_operacyjny", length = 45)
    private String systemOperacyjny;

    @Column(name = "opis", length = 1000)
    private String opis;

    @ManyToOne
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;

    public int getIdUrzadzenia() {
        return idUrzadzenia;
    }

    public void setIdUrzadzenia(int idUrzadzenia) {
        this.idUrzadzenia = idUrzadzenia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrSeryjny() {
        return nrSeryjny;
    }

    public void setNrSeryjny(String nrSeryjny) {
        this.nrSeryjny = nrSeryjny;
    }

    public DateTime getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(DateTime dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public String getSystemOperacyjny() {
        return systemOperacyjny;
    }

    public void setSystemOperacyjny(String systemOperacyjny) {
        this.systemOperacyjny = systemOperacyjny;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
