package entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class DistributoreAutomatico {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = "distributore")
    private List<Acquisto> acquisti;

    @Enumerated(EnumType.STRING)
    private FunzionamentoDistributore stato;

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

    public FunzionamentoDistributore getStato() {
        return stato;
    }

    public void setStato(FunzionamentoDistributore stato) {
        this.stato = stato;
    }

    public DistributoreAutomatico() {
    }

    public DistributoreAutomatico(UUID id, List<Acquisto> acquisti, FunzionamentoDistributore stato) {
        this.id = id;
        this.acquisti = acquisti;
        this.stato = stato;
    }
}
