package entities;

import javax.persistence.*;

import java.util.UUID;


@Entity
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;

    @OneToOne
    @JoinColumn (nullable = false, unique = true)
    private Tessera tessera;

    public void setId() {
        this.id = UUID.randomUUID();
    }
    public Utente(){

    }

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public UUID getId() {
        return id;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tessera=" + tessera +
                '}'+ "tessera"+ getTessera();
    }
}
