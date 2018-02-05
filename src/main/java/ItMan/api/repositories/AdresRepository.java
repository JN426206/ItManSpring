package ItMan.api.repositories;

import ItMan.api.entities.Adres;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdresRepository extends CrudRepository<Adres, Integer> {


    @Query("select count(*) from Adres p where p.idAdres = ?1")
    Integer checkIfExist(Integer id);
}