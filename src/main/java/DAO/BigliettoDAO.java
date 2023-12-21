package DAO;

import entities.Biglietto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BigliettoDAO {
    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Biglietto biglietto) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(biglietto);
        transaction.commit();

        System.out.println("Biglietto " + biglietto.getId() +" Emissione:"+ biglietto.getDataEmissione() + " aggiunto correttamente!");
    }

    public Biglietto findById(long id) {
        return em.find(Biglietto.class, id);
    }


    public void findByIdAndDelete(long id) {
        Biglietto found = this.findById(id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();

            System.out.println("L'abbonamento " + found.getId() +" "+" è stato eliminato correttamente!");
        } else {
            System.out.println("L'abbonamento " + id + " non è stato trovato");
        }


    }
}