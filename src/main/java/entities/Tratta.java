package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "findByNameZonaPartenza", query = "SELECT a FROM Tratta a WHERE LOWER(a.zonaPartenza) LIKE LOWER(:searchString)")
public class Tratta {
    @Id
    @GeneratedValue
    private long id;
    private String zonaPartenza;
    private String capolinea;
    private double tempoMedioPercorrenza;
    @ManyToMany
    @JoinTable(name = "mezzoDiTrasporto_tratta",
               joinColumns = @JoinColumn(name = "tratta_id"),
               inverseJoinColumns = @JoinColumn(name = "mezzoDiTrasporto_id"))
    private List<MezzoDiTrasporto> mezziDiTrasporto;


// COSTRUTTORI

    public Tratta() {
    }
    public Tratta(String zonaPartenza, String capolinea, double tempoMedioPercorrenza) {
        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
    }
    public Tratta(String zonaPartenza, String capolinea, double tempoMedioPercorrenza, List<MezzoDiTrasporto> mezziDiTrasporto) {
        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
        this.mezziDiTrasporto = mezziDiTrasporto;
    }

    // GETTER E SETTER
    public long getId() {
        return id;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public double getTempoMedioPercorrenza() {
        return tempoMedioPercorrenza;
    }

    public void setTempoMedioPercorrenza(double tempoMedioPercorrenza) {
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
    }

    public List<MezzoDiTrasporto> getMezziDiTrasporto() {
        return mezziDiTrasporto;
    }

    public void setMezziDiTrasporto(List<MezzoDiTrasporto> mezziDiTrasporto) {
        this.mezziDiTrasporto = mezziDiTrasporto;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoMedioPercorrenza=" + tempoMedioPercorrenza +
                '}';
    }
}