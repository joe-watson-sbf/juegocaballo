package co.com.sofkau.juegocaballo.usecase;

import co.com.sofkau.juegocaballo.domain.command.IniciarJuegoCommand;
import co.com.sofkau.juegocaballo.usecase.port.JuegoRepository;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IniciarJuegoUseCase implements Function<IniciarJuegoCommand, Object> {

    private final JuegoRepository repository;

    public IniciarJuegoUseCase(JuegoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Object apply(IniciarJuegoCommand command) {
        var juego = repository.getOneById(command.getIdJuego());

        System.out.println("\nJUEGO INICIA\n");
        juego.iniciar();
        while (juego.jugando()){
            juego.moverCabbalos();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(juego);
        }

        System.out.println("\nJUEGO TERMINADO\n");
        System.out.println("PODIO");
        System.out.println(juego.podio());
        return repository.update(juego);
    }
}
