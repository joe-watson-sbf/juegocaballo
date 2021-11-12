package co.com.sofkau.juegocaballo.domain.command;

import java.io.Serializable;

public class IniciarJuegoCommand implements Serializable {

    private String idJuego;

    public IniciarJuegoCommand(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }
}
