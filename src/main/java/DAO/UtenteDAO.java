package DAO;


import entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class UtenteDAO {

    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(utente);
            transaction.commit();

            System.out.println("Utente " + utente.getId() +" "+ utente.getNome() +" "+utente.getCognome() + " aggiunto correttamente!");
        }

        public Utente findById(long id) {
            return em.find(Utente.class, id);
        }


        public void findByIdAndDelete(long id) {
            Utente found = this.findById(id);

            if (found != null) {

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();

                em.remove(found);
                transaction.commit();

                System.out.println("La persona " + found.getId() +" "+ found.getNome() +" "+ found.getCognome() +" eliminato correttamente!");
            } else {
                System.out.println("La persona " + id + " non è stato trovato");
            }


        }
    }

