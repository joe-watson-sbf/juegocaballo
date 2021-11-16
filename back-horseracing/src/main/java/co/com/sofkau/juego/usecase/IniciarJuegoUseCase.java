package co.com.sofkau.juego.usecase;

import co.com.sofkau.juego.domain.Juego;
import co.com.sofkau.juego.domain.command.IniciarJuegoCommand;
import co.com.sofkau.juego.usecase.port.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IniciarJuegoUseCase implements Function<IniciarJuegoCommand, Juego> {

    private final JuegoRepository repository;

    @Autowired
    public IniciarJuegoUseCase(JuegoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Juego apply(IniciarJuegoCommand command) {
        var juego = repository.buscarPorId(command.getJuegoId());

        juego.iniciar();
        repository.update(juego);

        return juego;
    }
}
