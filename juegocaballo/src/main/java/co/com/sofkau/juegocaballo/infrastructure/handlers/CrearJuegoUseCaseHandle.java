package co.com.sofkau.juegocaballo.infrastructure.handlers;

import co.com.sofkau.juegocaballo.domain.command.CrearJuegoCommand;
import co.com.sofkau.juegocaballo.usecase.CrearJuegoUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CrearJuegoUseCaseHandle {
    private final CrearJuegoUseCase useCase;

    public CrearJuegoUseCaseHandle(CrearJuegoUseCase useCase) {
        this.useCase = useCase;
    }

    @EventListener
    public void handle(CrearJuegoCommand command){
         useCase.apply(command);
    }
}
