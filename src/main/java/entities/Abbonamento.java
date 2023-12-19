package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Abbonamento extends Acquisto {

    @Enumerated(EnumType.STRING)
    private DurataAbbonamento durata;

    private Date dataScadenza;

    @ManyToOne
    @JoinColumn(name = "tessera_id", nullable = false)
    private Tessera tessera;


    public DurataAbbonamento getDurata() {
        return durata;
    }

    public void setDurata(DurataAbbonamento durata) {
        this.durata = durata;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public Abbonamento() {
    }

    public Abbonamento(UUID id, Date dataEmissione, Rivenditore rivenditore, DistributoreAutomatico distributore, DurataAbbonamento durata, Date dataScadenza) {
        super(id, dataEmissione, rivenditore, distributore);
        this.durata = durata;
        this.dataScadenza = dataScadenza;
    }
}
