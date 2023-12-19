package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Mezzi_Di_Trasporto")
public class MezzoDiTrasporto {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    private TipoMezzo tipoMezzo;
    private int capienza;
    @Enumerated(EnumType.STRING)
    private StatoDelMezzo statoDelMezzo;
    private LocalDate periodoInizio;    // ancora non associata a dei costruttori
    private LocalDate periodoFine;      // ancora non associata a dei costruttori

    //COSTRUTTORI
    public MezzoDiTrasporto() {}
    public MezzoDiTrasporto(TipoMezzo tipoMezzo, int capienza, StatoDelMezzo statoDelMezzo) {
        this.tipoMezzo = tipoMezzo;
        this.capienza = capienza;
        this.statoDelMezzo = statoDelMezzo;
    }
    public MezzoDiTrasporto(TipoMezzo tipoMezzo, int capienza) {
        this.tipoMezzo = tipoMezzo;
        this.capienza = capienza;
    }

    //GETTER E SETTER

    public long getId() {
        return id;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public StatoDelMezzo getStatoDelMezzo() {
        return statoDelMezzo;
    }

    public void setStatoDelMezzo(StatoDelMezzo statoDelMezzo) {
        this.statoDelMezzo = statoDelMezzo;
    }

    public LocalDate getPeriodoInizio() {
        return periodoInizio;
    }

    public void setPeriodoInizio(LocalDate periodoInizio) {
        this.periodoInizio = periodoInizio;
    }

    public LocalDate getPeriodoFine() {
        return periodoFine;
    }

    public void setPeriodoFine(LocalDate periodoFine) {
        this.periodoFine = periodoFine;
    }

    @Override
    public String toString() {
        return "MezzoDiTrasporto{" +
                "id=" + id +
                ", tipoMezzo=" + tipoMezzo +
                ", capienza=" + capienza +
                ", statoDelMezzo=" + statoDelMezzo +
                '}';
    }
}
