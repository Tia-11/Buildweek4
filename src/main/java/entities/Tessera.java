package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Tessera {

        @Id
        @GeneratedValue
        private long id;
        private LocalDate dataEmissione;
        private LocalDate dataScadenza;

        //bidirezionalità
        @OneToOne(mappedBy = "tessera")
        private Utente utente;

        @OneToMany(mappedBy = "tessera")
        private Abbonamento abbonamento;



        public Tessera (){

        }

        public Tessera(LocalDate dataEmissione) {
                this.dataEmissione = dataEmissione;
                this.dataScadenza = dataEmissione.plusYears(1);
        }

        public static Tessera nuovaTessera() {
                LocalDate oggi = LocalDate.now();
                return new Tessera(oggi);
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

        public long getId() {
                return id;
        }

        public Utente getUtente() {
                return utente;
        }

        public void setUtente(Utente utente) {
                this.utente = utente;
        }

        public Abbonamento getAbbonamento() {
                return abbonamento;
        }

        public void setAbbonamento(Abbonamento abbonamento) {
                this.abbonamento = abbonamento;
        }

        @Override
        public String toString() {
                return "Tessera{" +
                        "id=" + id +
                        ", dataEmissione=" + dataEmissione +
                        ", dataScadenza=" + dataScadenza +
                        '}';
        }
}


