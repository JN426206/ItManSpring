package ItMan.api.hibernate.manager;

import ItMan.api.entities.Adres;
import ItMan.api.entities.Firma;
import ItMan.api.entities.Haslo;
import ItMan.api.entities.Urzadzenie;
import ItMan.api.services.FirmaService;
import org.joda.time.DateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FirmaManager {
    public FirmaManager(){

    }

    public static void generateData(EntityManager entityManager) {
        Adres adres = new Adres("Długa", "60-150", "15", "Poznań");
        Firma firma = new Firma("Testowa firma 1","123123","213423423", adres);
        Haslo haslo = new Haslo("Dell Latitude E6540", "asdsadasjdsajdnas", DateTime.now(), firma);
        Urzadzenie urzadzenie = new Urzadzenie("Dell Latitude E6540", "L", "Używany", "DELL", "LATITUDE E6540", "LO35R235DA", DateTime.now(), firma, "Windows 10 PRO");

        entityManager.persist(firma);
        entityManager.persist(haslo);
        entityManager.persist(urzadzenie);

        adres = new Adres("Mokra", "20-320", "1A", "Tarnowo");
        firma = new Firma("Lokon","4458875698","2541698354", adres);
        haslo = new Haslo("Thinkpad W540", "asdqawdasdwd", DateTime.now(), firma);
        urzadzenie = new Urzadzenie("Thinkpad W540", "L", "Używany", "LENOVO", "THINKPAD W540", "OP099EIU56", DateTime.now(), firma, "Windows 7 SP2 PRO");

        entityManager.persist(firma);
        entityManager.persist(haslo);
        entityManager.persist(urzadzenie);

        entityManager.getTransaction().commit();
    }

    public static void main(String[] args) {
        System.out.println("Start FirmaManager");
        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            generateData(entityManager);

            entityManager.close();



        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }
}
