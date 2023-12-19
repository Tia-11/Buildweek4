package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Tessera {

        @Id
        @GeneratedValue
        private UUID id;
        private LocalDate dataEmissione;
        private LocalDate dataScadenza;

        @OneToOne(mappedBy = "tessera")
        private Utente utente;


        public void setId() {
            this.id = UUID.randomUUID();
        }
        public Tessera (){

        }

        public Tessera(LocalDate dataEmissione, LocalDate dataScadenza) {
                this.dataEmissione = dataEmissione;
                this.dataScadenza = dataScadenza;
        }

        public LocalDate getDataEmissione() {
                return dataEmissione;
        }

        public void setDataEmissione(LocalDate dataEmissione) {
                this.dataEmissione = dataEmissione;
        }

        public LocalDate getDataScadenza() {
                return dataScadenza;
        }

        public void setDataScadenza(LocalDate dataScadenza) {
                this.dataScadenza = dataScadenza;
        }

        public UUID getId() {
                return id;
        }

        public Utente getUtente() {
                return utente;
        }

        public void setUtente(Utente utente) {
                this.utente = utente;
        }

        @Override
        public String toString() {
                return "Tessera{" +
                        "id=" + id +
                        ", dataEmissione=" + dataEmissione +
                        ", dataScadenza=" + dataScadenza +
                        ", utente=" + utente +
                        '}';
        }
}


