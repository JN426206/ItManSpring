package ItMan.api.repositories;

import ItMan.api.entities.Firma;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FirmaRepository extends CrudRepository<Firma, Integer> {

    Firma findByNazwa(String nazwa);

    @Query("select count(*) from Firma p where p.idFirmy = ?1")
    Integer checkIfExist(Integer id);
}
