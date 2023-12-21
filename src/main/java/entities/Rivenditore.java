package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Rivenditore {
    @Id
    @GeneratedValue
    private UUID id;

    private String nomeRivenditore;

    @OneToMany(mappedBy = "rivenditore")
    private List<Acquisto> acquisti;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Acquisto> getAcquisti() {
        return acquisti;
    }

    public void setAcquisti(List<Acquisto> acquisti) {
        this.acquisti = acquisti;
    }

    public String getNomeRivenditore() {
        return nomeRivenditore;
    }

    public void setNomeRivenditore(String nomeRivenditore) {
        this.nomeRivenditore = nomeRivenditore;
    }

    public Rivenditore() {
    }

    public Rivenditore(UUID id, String nomeRivenditore, List<Acquisto> acquisti) {
        this.id = id;
        this.nomeRivenditore = nomeRivenditore;
        this.acquisti = acquisti;
    }

    public void aggiungiAcquisto(Acquisto acquisto) {
        if (acquisti == null) {
            acquisti = new ArrayList<>();
        }
        acquisti.add(acquisto);
        acquisto.setRivenditore(this);
    }
}
