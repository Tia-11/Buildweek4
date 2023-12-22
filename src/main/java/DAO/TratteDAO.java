package DAO;

import entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class TratteDAO {
    private final EntityManager em;

    // COSTRUTTORI
    public TratteDAO(EntityManager em) {
        this.em = em;
    }

    // METODI
    public void Save(Tratta tratta) {
        em.getTransaction().begin();
        em.persist(tratta);
        em.getTransaction().commit();
        System.out.println("tratta " + tratta.getZonaPartenza() + "-" + tratta.getCapolinea() + " salvata nel database");
    }
    public Tratta FindById(long id) {
        return em.find(Tratta.class, id);
    }
    public void FindByIdAndDelete(long id) {
        Tratta tratta = FindById(id);
        em.getTransaction().begin();
        em.remove(tratta);
        em.getTransaction().commit();
        System.out.println("tratta " + tratta.getZonaPartenza() + "-" + tratta.getCapolinea() + " eliminata dal database!");
    }

    // NAMED QUERY
    public List<Tratta> findByNameZonaPartenza(String zonaPartenza) {
        TypedQuery<Tratta> query = em.createNamedQuery("findByNameZonaPartenza", Tratta.class);
        query.setParameter("searchString", "%" + zonaPartenza + "%");
        return query.getResultList();
    }


    // QUERY

    public List<Tratta> findAllTratte() {
        TypedQuery<Tratta> query = em.createQuery("SELECT a FROM Tratta a", Tratta.class);
        return query.getResultList();
    }
    public List<String> findAllZonePartenze() {
        TypedQuery<String> query = em.createQuery("SELECT a.zonaPartenza FROM Tratta a", String.class);
        return query.getResultList();
    }
    public void findByZonaPartenzaAndDelete(String oldZone, String newZone) {
        em.getTransaction().begin();
        Query modifyZonaPartenza = em.createQuery("UPDATE Tratta a SET a.zonaPartenza = :newZone WHERE a.zonaPartenza = :oldZone");
        modifyZonaPartenza.setParameter("newZone", newZone);
        modifyZonaPartenza.setParameter("oldZone", oldZone);
        int numberOfZoneUpdated = modifyZonaPartenza.executeUpdate();
        em.getTransaction().commit();
        if (numberOfZoneUpdated > 0) {
            System.out.println("Zona di partenza " + oldZone + " modificata in " + newZone);
        } else {
            System.out.println("nessuna zona di nome " + oldZone + " trovata nel database");
        }

    }
}
