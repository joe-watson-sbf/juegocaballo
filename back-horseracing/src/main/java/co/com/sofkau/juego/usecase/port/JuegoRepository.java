package co.com.sofkau.juego.usecase.port;

import co.com.sofkau.juego.domain.Juego;


public interface JuegoRepository {
    Juego guardar(Juego juego);
    Juego buscarPorId(String id);
    Juego update(Juego juego);
}
