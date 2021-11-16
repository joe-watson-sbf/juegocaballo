package co.com.sofkau.juegocaballo.infrastructure.model;

public class PistaDocumento {
    private Integer kilometros;
    private Integer numeroCarriles;

    public PistaDocumento() {
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public Integer getNumeroCarriles() {
        return numeroCarriles;
    }

    public void setNumeroCarriles(Integer numeroCarriles) {
        this.numeroCarriles = numeroCarriles;
    }
}
