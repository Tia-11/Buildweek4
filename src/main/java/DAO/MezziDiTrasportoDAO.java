package DAO;

import entities.MezzoDiTrasporto;

import javax.persistence.EntityManager;

public class MezziDiTrasportoDAO {
    private final EntityManager em;

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
    public MezzoDiTrasporto FindById(long id) {
        return em.find(MezzoDiTrasporto.class, id);
    }
    public void FindByIdAndDelete(long id) {
        MezzoDiTrasporto mezzo = FindById(id);
        if (mezzo != null) {
            em.getTransaction().begin();
            em.remove(mezzo);
            em.getTransaction().commit();
            System.out.println("mezzo con id " + mezzo.getId() + " eliminato correttamente dal database");
        } else {
            System.err.println("l'id fornito " + "(" + id + ")" + " non corrisponde a nessun mezzo");
        }
    }
}
