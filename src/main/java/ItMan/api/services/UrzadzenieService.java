package ItMan.api.services;

import ItMan.api.entities.Urzadzenie;

public interface UrzadzenieService {

    Iterable<Urzadzenie> listAllUrzadzenia();

    Iterable<Urzadzenie> listAllUrzadzeniaPagging(Integer pageNr, Integer howManyOnPage);

    Urzadzenie getUrzadzenieById(Integer id);

    Iterable<Urzadzenie> getUrzadzeniaByIdFirmy(Integer id);

    void removeUrzadzenie(Integer id);

    Urzadzenie saveUrzadzenie(Urzadzenie urzadzenie);

    boolean checkIfExist(Integer id);
}
