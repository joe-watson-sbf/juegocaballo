package co.com.sofkau.juego.usecase;

import co.com.sofkau.juego.domain.Juego;
import co.com.sofkau.juego.domain.command.CrearJuegoCommand;
import co.com.sofkau.juego.usecase.port.JuegoRepository;
import co.com.sofkau.juego.usecase.validator.JuegoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CrearJuegoUseCase implements Function<CrearJuegoCommand, Juego> {

    private final JuegoRepository repository;

    @Autowired
    public CrearJuegoUseCase(JuegoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Juego apply(CrearJuegoCommand command) {
        command.getJinetes().forEach(jinete -> jinete.id(UUID.randomUUID().toString()));
        var juego = Juego.builder()
                .id(UUID.randomUUID().toString())
                .jinetes(command.getJinetes())
                .kilometros(command.getKilometros())
                .build();

        JuegoValidator.validarCreacionJuego(juego);

        return repository.guardar(juego);
    }
}
