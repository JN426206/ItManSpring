package ItMan.api.hibernate.queries;

import ItMan.api.entities.Firma;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Queries {
    EntityManager entityManager;

    public Queries(EntityManager entityManager)  { this.entityManager = entityManager; }

    public List<Firma> getAllFirmy(){
        Query query = entityManager.createQuery("SELECT k from Firma k");
        return query.getResultList();
    }
}
