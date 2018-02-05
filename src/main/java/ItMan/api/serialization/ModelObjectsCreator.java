package ItMan.api.serialization;

import ItMan.api.entities.Adres;
import ItMan.api.entities.Firma;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ModelObjectsCreator {

    Adres adres = new Adres("Długa", "60-150", "15", "Poznań");
    Firma firma = new Firma("nazwa jakas", "2093123","9912312",adres);



    List<Firma> firmy = new ArrayList<>();

    public void init(){
        firmy.add(this.firma);

    }

    public List<Firma> getFirmy() { return firmy; }

    public void setFirmy(List<Firma> firmy) { this.firmy = firmy; }

    public ModelObjectsCreator() { init(); }
}
