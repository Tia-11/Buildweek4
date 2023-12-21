package DAO;

import entities.Rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class RivenditoreDAO {
    private final EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore rivenditore) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(rivenditore);
        transaction.commit();

        System.out.println("Rivenditore " + rivenditore.getId() + " aggiunto correttamente!");
    }

    public Rivenditore findById(UUID id) {
        return em.find(Rivenditore.class, id);
    }

    public void findByIdAndDelete(UUID id) {
        Rivenditore found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();

            System.out.println("Il rivenditore " + found.getId() + " è stato eliminato correttamente!");
        } else {
            System.out.println("Il rivenditore " + id + " non è stato trovato");
        }
    }
}
