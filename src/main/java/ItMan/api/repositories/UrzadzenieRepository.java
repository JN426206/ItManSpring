package ItMan.api.repositories;

import ItMan.api.entities.Urzadzenie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UrzadzenieRepository extends CrudRepository<Urzadzenie, Integer>, PagingAndSortingRepository<Urzadzenie, Integer> {

    Iterable<Urzadzenie> findUrzadzeniesByFirma_IdFirmy(Integer idFirmy);

    @Query("select p from Urzadzenie p where p.firma.idFirmy = ?1")
    Iterable<Urzadzenie> selectUrzadzeniaByIdFirmy(Integer id);

    @Query("select count(*) from Urzadzenie p where p.idUrzadzenia = ?1")
    Integer checkIfExist(Integer id);
}