package ItMan.api.services;

import ItMan.api.entities.Firma;

public interface FirmaService {
    Iterable<Firma> listAllFirmy();

    Firma getFirmaById(Integer id);

    Firma saveFirma(Firma firma);

    void removeFirma(Integer id);

    Firma updateFirma(Firma firma);

    Boolean checkIfExist(Integer id);
}
