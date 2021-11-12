package co.com.sofkau.juegocaballo.usecase;

import co.com.sofkau.juegocaballo.domain.command.CrearJuegoCommand;
import co.com.sofkau.juegocaballo.domain.entity.Juego;
import co.com.sofkau.juegocaballo.domain.entity.Pista;
import co.com.sofkau.juegocaballo.usecase.port.JuegoRepository;
import co.com.sofkau.juegocaballo.usecase.validator.JuegoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.function.Function;

@Component
public class CrearJuegoUseCase implements Function<CrearJuegoCommand, String> {


    private final JuegoRepository repository;

    @Autowired
    public CrearJuegoUseCase(JuegoRepository repository) {
        this.repository = repository;
    }

    @Override
    public String apply(CrearJuegoCommand command) {

        command.getJinetes()
                .forEach(jinete -> jinete.id(UUID.randomUUID().toString()));

        var juegoToSave = Juego.builder()
                .id(UUID.randomUUID().toString())
                .jinetes(command.getJinetes())
                .pista(new Pista(command.getKilometros(), command.getJinetes().size()))
                .build();

        JuegoValidator.validarCreacionJuego(juegoToSave);

        return repository.save(juegoToSave);
    }
}
