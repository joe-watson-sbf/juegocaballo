package co.com.sofkau.juegocaballo.infrastructure.handlers;

import co.com.sofkau.juegocaballo.domain.command.IniciarJuegoCommand;
import co.com.sofkau.juegocaballo.usecase.IniciarJuegoUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class IniciarJuegoUseCaseHandle {

    private final IniciarJuegoUseCase useCase;

    public IniciarJuegoUseCaseHandle(IniciarJuegoUseCase useCase) {
        this.useCase = useCase;
    }


    @EventListener
    public void handle(IniciarJuegoCommand command){
        System.out.println("COMMAND RECIEVED --> " + command.getIdJuego());
        //useCase.apply(command);
    }
}
