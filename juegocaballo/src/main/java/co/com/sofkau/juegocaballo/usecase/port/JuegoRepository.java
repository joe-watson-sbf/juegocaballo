package co.com.sofkau.juegocaballo.usecase.port;

import co.com.sofkau.juegocaballo.domain.entity.Juego;

public interface JuegoRepository {
    Juego getOneById(String id);
    String save(Juego juego);
    Juego update(Juego juego);
}
