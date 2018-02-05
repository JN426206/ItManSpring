package ItMan.api.services;

import ItMan.api.entities.Adres;

public interface AdresService {
    Iterable<Adres>  listAllAdres();

    Adres getAdresById(Integer id);

    Adres saveAdres(Adres adres);

    boolean checkIfExist(Integer id);
}
