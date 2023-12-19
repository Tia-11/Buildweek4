package entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class InManutenzione {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate inizioManutenzione;
    private LocalDate fineManutenzione;
    @ManyToOne
    @JoinColumn(name = "mezzoDiTrasporto_id", nullable = false)
    private MezzoDiTrasporto mezzoDiTrasporto;

    // COSTRUTTORI

    public InManutenzione() {}

    public InManutenzione(LocalDate inizioManutenzione, LocalDate fineManutenzione, MezzoDiTrasporto mezzoDiTrasporto) {
        this.inizioManutenzione = inizioManutenzione;
        this.fineManutenzione = fineManutenzione;
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    // GETTER E SETTER


    public long getId() {
        return id;
    }

    public LocalDate getInizioManutenzione() {
        return inizioManutenzione;
    }

    public void setInizioManutenzione(LocalDate inizioManutenzione) {
        this.inizioManutenzione = inizioManutenzione;
    }

    public LocalDate getFineManutenzione() {
        return fineManutenzione;
    }

    public void setFineManutenzione(LocalDate fineManutenzione) {
        this.fineManutenzione = fineManutenzione;
    }

    public MezzoDiTrasporto getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }

    public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }

    @Override
    public String toString() {
        return "InManutenzione{" +
                "id=" + id +
                ", inizioManutenzione=" + inizioManutenzione +
                ", fineManutenzione=" + fineManutenzione +
                '}';
    }
}
