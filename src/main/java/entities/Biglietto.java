package entities;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@Entity
public class Biglietto extends Acquisto {

    private Date dataVidimazione;

    public Date getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(Date dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    public Biglietto() {
    }

    public Biglietto(UUID id, Date dataEmissione, Rivenditore rivenditore, DistributoreAutomatico distributore, Date dataVidimazione) {
        super(id, dataEmissione, rivenditore, distributore);
        this.dataVidimazione = dataVidimazione;
    }
}
