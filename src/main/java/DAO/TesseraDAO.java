package DAO;

import entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesseraDAO {

        private final EntityManager em;

        public TesseraDAO(EntityManager em) {
            this.em = em;
        }
        public void save(Tessera tessera) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(tessera);
            transaction.commit();

            System.out.println("Tessera " + tessera.getId() +" Emissione:"+ tessera.getDataEmissione() +" Scadenza:"+tessera.getDataScadenza() + " aggiunto correttamente!");
        }

        public Tessera findById(long id) {
            return em.find(Tessera.class, id);
        }


        public void findByIdAndDelete(long id) {
            Tessera found = this.findById(id);

            if (found != null) {

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();

                em.remove(found);
                transaction.commit();

                System.out.println("La tessera " + found.getId() +" "+ found.getDataScadenza() +" "+ found.getDataScadenza() +" è stata eliminata correttamente!");
            } else {
                System.out.println("La tessera " + id + " non è stata trovata");
            }


        }
    }

