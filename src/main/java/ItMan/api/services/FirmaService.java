package ItMan.api.services;

import ItMan.api.entities.Firma;

public interface FirmaService {
    Iterable<Firma> listAllFirmy();

    Firma getFirmaById(Integer id);

    Firma saveFirma(Firma firma);

    Boolean checkIfExist(Integer id);
}
