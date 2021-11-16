package co.com.sofkau.juegocaballo.domain.command;

import co.com.sofkau.juegocaballo.domain.entity.Jinete;

import java.io.Serializable;
import java.util.Set;

public class CrearJuegoCommand implements Serializable {

    private Set<Jinete> jinetes;
    private Integer kilometros;
    private String tipo;

    public CrearJuegoCommand(Set<Jinete> jinetes, Integer kilometros) {
        this.jinetes = jinetes;
        this.kilometros = kilometros;
        this.tipo = "CrearJuegoCommand";
    }

    public Set<Jinete> getJinetes() {
        return jinetes;
    }

    public void setJinetes(Set<Jinete> jinetes) {
        this.jinetes = jinetes;
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "CrearJuegoCommand{" +
                "jinetes=" + jinetes +
                ", kilometros=" + kilometros +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
