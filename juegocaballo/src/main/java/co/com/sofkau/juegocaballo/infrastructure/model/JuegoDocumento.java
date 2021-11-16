package co.com.sofkau.juegocaballo.infrastructure.model;
import co.com.sofkau.juegocaballo.domain.entity.Pista;
import co.com.sofkau.juegocaballo.domain.entity.Podio;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
public class JuegoDocumento {
    @Id
    private String id;
    private Set<JineteDocumento> jinetes;
    private Pista pista;
    private Podio podio;
    private Boolean jugando;

    public JuegoDocumento() {
        this.podio = null;
        this.jinetes = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<JineteDocumento> getJinetes() {
        return jinetes;
    }

    public void setJinetes(Set<JineteDocumento> jinetes) {
        this.jinetes = jinetes;
    }


    public Pista getPista() {
        return pista;
    }

    public void setPistaDocumento(Pista pista) {
        this.pista = pista;
    }

    public Podio getPodioDocumento() {
        return podio;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public Podio getPodio() {
        return podio;
    }

    public void setPodio(Podio podio) {
        this.podio = podio;
    }

    public Boolean getJugando() {
        return jugando;
    }

    public void setJugando(Boolean jugando) {
        this.jugando = jugando;
    }

}
