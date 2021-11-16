package co.com.sofkau.juegocaballo.usecase;

import co.com.sofkau.juegocaballo.domain.command.IniciarJuegoCommand;
import co.com.sofkau.juegocaballo.domain.entity.Juego;
import co.com.sofkau.juegocaballo.usecase.port.JuegoRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;

@Component
public class IniciarJuegoUseCase implements Function<IniciarJuegoCommand, Juego> {

    private final JuegoRepository repository;

    public IniciarJuegoUseCase(JuegoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Juego apply(IniciarJuegoCommand command) {
        System.out.println("COMMANDO: " + command);
        var juego = repository.getOneById(command.getIdJuego());

        System.out.println("\nJUEGO INICIA\n");
        juego.iniciar();
        while (juego.jugando()){

            juego.moverCabbalos();
            System.out.println(juego);

        }

        System.out.println("\nJUEGO TERMINADO\n");
        System.out.println("PODIO");
        System.out.println(juego.podio());

        return juego;
    }


}
