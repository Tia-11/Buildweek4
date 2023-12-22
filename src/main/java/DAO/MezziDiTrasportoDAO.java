package DAO;

import entities.MezzoDiTrasporto;
import entities.StatoDelMezzo;
import entities.TipoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    // NAMED QUERY
    public List<MezzoDiTrasporto> findByType(TipoMezzo tipoMezzo) {
        TypedQuery<MezzoDiTrasporto> getMezzoByType = em.createNamedQuery("findByType", MezzoDiTrasporto.class);
        getMezzoByType.setParameter("tipoMezzo", tipoMezzo);
        return getMezzoByType.getResultList();
    }
    public List<MezzoDiTrasporto> findByStatoDelMezzo(StatoDelMezzo statoDelMezzo) {
        TypedQuery<MezzoDiTrasporto> getMezzoByStato = em.createNamedQuery("findByStatoDelMezzo", MezzoDiTrasporto.class);
        getMezzoByStato.setParameter("statoDelMezzo", statoDelMezzo);
        return getMezzoByStato.getResultList();
    }
    // QUERY
    public List<MezzoDiTrasporto> findAllVehicles() {
        TypedQuery<MezzoDiTrasporto> getAllQuery = em.createQuery("SELECT a FROM MezzoDiTrasporto a", MezzoDiTrasporto.class);
        return getAllQuery.getResultList();
    }
}
