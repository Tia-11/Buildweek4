package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Abbonamento extends Acquisto {

    @Enumerated(EnumType.STRING)
    private DurataAbbonamento durata;

    private Date dataScadenza;


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

    public Abbonamento() {
    }

    public Abbonamento(UUID id, Date dataEmissione, Rivenditore rivenditore, DistributoreAutomatico distributore, DurataAbbonamento durata, Date dataScadenza) {
        super(id, dataEmissione, rivenditore, distributore);
        this.durata = durata;
        this.dataScadenza = dataScadenza;
    }
}
