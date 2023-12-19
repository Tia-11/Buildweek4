package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Rivenditore {
    @Id
    @GeneratedValue
    private UUID id;

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

    public Rivenditore() {
    }

    public Rivenditore(UUID id, List<Acquisto> acquisti) {
        this.id = id;
        this.acquisti = acquisti;
    }
}