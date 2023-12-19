package DAO;

import entities.MezzoDiTrasporto;

import javax.persistence.EntityManager;

public class MezziDiTrasportoDAO {
    private EntityManager em;

    // COSTRUTTORI
    public MezziDiTrasportoDAO(EntityManager em) {
        this.em = em;
    }

    // METODI
    public void Save(MezzoDiTrasporto mezzoDiTrasporto) {
        em.getTransaction().begin();
        em.persist(mezzoDiTrasporto);
        em.getTransaction().commit();
        System.out.println("mezzo con id " + mezzoDiTrasporto.getId() + " salvato correttamente nel database");
    }
    public MezzoDiTrasporto findById(long id) {
        return em.find(MezzoDiTrasporto.class, id);
    }
    public void findByIdAndDelete(long id) {
        MezzoDiTrasporto mezzo = findById(id);
        em.getTransaction().begin();
        em.remove(mezzo);
        em.getTransaction().commit();
        System.out.println("mezzo con id " + mezzo.getId() + " eliminato correttamente dal database");
    }



}
