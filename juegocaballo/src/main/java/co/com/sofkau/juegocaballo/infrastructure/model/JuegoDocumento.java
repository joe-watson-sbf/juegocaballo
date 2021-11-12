package co.com.sofkau.juegocaballo.infrastructure.model;

import co.com.sofkau.juegocaballo.domain.entity.Jinete;
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
    private Set<Jinete> jinetes;
    private Pista pista;
    private Podio podio;

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

    public Set<Jinete> getJinetes() {
        return jinetes;
    }

    public void setJinetes(Set<Jinete> jinetes) {
        this.jinetes = jinetes;
    }


    public Pista getPista() {
        return pista;
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
}
