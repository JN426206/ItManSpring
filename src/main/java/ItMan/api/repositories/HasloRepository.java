package ItMan.api.repositories;

import ItMan.api.entities.Haslo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HasloRepository extends CrudRepository<Haslo, Integer> {

    Iterable<Haslo> findHaslosByFirma_IdFirmy(Integer idFirmy);

    @Query("select count(*) from Haslo p where p.idHasla = ?1")
    Integer checkIfExist(Integer id);
}
