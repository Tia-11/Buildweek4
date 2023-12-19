package DAO;

import entities.Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbbonamentoDAO {
        private final EntityManager em;

        public AbbonamentoDAO(EntityManager em) {
            this.em = em;
        }
        public void save(Abbonamento abbonamento) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(abbonamento);
            transaction.commit();

            System.out.println("Tessera " + abbonamento.getId() +" Emissione:"+ abbonamento.getDataEmissione() +" Scadenza:"+abbonamento.getDataScadenza() + " aggiunto correttamente!");
        }

        public Abbonamento findById(long id) {
            return em.find(Abbonamento.class, id);
        }


        public void findByIdAndDelete(long id) {
            Abbonamento found = this.findById(id);

            if (found != null) {

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();

                em.remove(found);
                transaction.commit();

                System.out.println("L'abbonamento " + found.getId() +" "+ found.getDataScadenza() +" "+ found.getDataScadenza() +" è stato eliminato correttamente!");
            } else {
                System.out.println("L'abbonamento " + id + " non è stato trovato");
            }


        }
    }

