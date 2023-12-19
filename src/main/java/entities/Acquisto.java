package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

abstract class Acquisto {
    @Id
    @GeneratedValue
    private UUID id;

    private Date dataEmissione;

    @ManyToOne
    private Rivenditore rivenditore;

    @ManyToOne
    private DistributoreAutomatico distributore;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Rivenditore getRivenditore() {
        return rivenditore;
    }

    public void setRivenditore(Rivenditore rivenditore) {
        this.rivenditore = rivenditore;
    }

    public DistributoreAutomatico getDistributore() {
        return distributore;
    }

    public void setDistributore(DistributoreAutomatico distributore) {
        this.distributore = distributore;
    }


    public Acquisto() {
    }

    public Acquisto(UUID id, Date dataEmissione, Rivenditore rivenditore, DistributoreAutomatico distributore) {
        this.id = id;
        this.dataEmissione = dataEmissione;
        this.rivenditore = rivenditore;
        this.distributore = distributore;
    }
}
