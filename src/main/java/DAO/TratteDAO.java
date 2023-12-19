package DAO;

import entities.Tratta;

import javax.persistence.EntityManager;

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
}
