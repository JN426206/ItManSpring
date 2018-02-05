package ItMan.api.services;

import ItMan.api.entities.Haslo;

public interface HasloService {

    Iterable<Haslo> listAllHaslo();

    Haslo getHasloById(Integer id);

    Iterable<Haslo> getHasloByIdFirmy(Integer idFirmy);

    Haslo saveHaslo(Haslo haslo);

    boolean checkIfExist(Integer id);
}
