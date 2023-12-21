package DAO;

import entities.DistributoreAutomatico;
import java.util.UUID;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DistributoreAutomaticoDAO {
    private final EntityManager em;

    public DistributoreAutomaticoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(DistributoreAutomatico distributore) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(distributore);
        transaction.commit();

        System.out.println("Distributore " + distributore.getId() + " aggiunto correttamente!");
    }

    public DistributoreAutomatico findById(UUID id) {
        return em.find(DistributoreAutomatico.class, id);
    }

    public void findByIdAndDelete(UUID id) {
        DistributoreAutomatico found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();

            System.out.println("Il distributore " + found.getId() + " è stato eliminato correttamente!");
        } else {
            System.out.println("Il distributore " + id + " non è stato trovato");
        }
    }
}

