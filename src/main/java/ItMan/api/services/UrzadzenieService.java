package ItMan.api.services;

import ItMan.api.entities.Urzadzenie;

public interface UrzadzenieService {

    Iterable<Urzadzenie> listAllUrzadzenia();

    Urzadzenie getUrzadzenieById(Integer id);

    Iterable<Urzadzenie> getUrzadzeniaByIdFirmy(Integer id);

    Urzadzenie saveUrzadzenie(Urzadzenie urzadzenie);

    boolean checkIfExist(Integer id);
}
