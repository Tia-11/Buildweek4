package DAO;

import entities.InManutenzione;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class InManutenzioneDAO {
    private final EntityManager em;

    // COSTRUTTORE
    public InManutenzioneDAO(EntityManager em) {
        this.em = em;
    }

    // METODI
    public void Save(InManutenzione inManutenzione) {
        em.getTransaction().begin();
        em.persist(inManutenzione);
        em.getTransaction().commit();
        System.out.println("aggiunto periodo di manutenzione con id " + inManutenzione.getId() + " al mezzo " + inManutenzione.getMezzoDiTrasporto());
    }
    public InManutenzione FindById(long id) {
        return em.find(InManutenzione.class, id); // come faccio a mettere un'eccezione dato che mi deve ritornare un tipo InManutenzione?
    }
    public void FindByIdAndDelete(long id) {
        InManutenzione inManutenzione = FindById(id);
        if (inManutenzione != null) {
            em.getTransaction().begin();
            em.remove(inManutenzione);
            em.getTransaction().commit();
        } else {
            System.err.println("id di manutenzione " + id + " non presente nel database");
        }
    }
    // QUERY
    public List<InManutenzione> findAllMaintenances() {
        TypedQuery<InManutenzione> getAllQuery = em.createQuery("SELECT a FROM InManutenzione a", InManutenzione.class);
        return getAllQuery.getResultList();
    }
    public List<InManutenzione> findByDate(LocalDate startDate, LocalDate endDate) {
        TypedQuery<InManutenzione> query = em.createNamedQuery("findByDate", InManutenzione.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }
}
