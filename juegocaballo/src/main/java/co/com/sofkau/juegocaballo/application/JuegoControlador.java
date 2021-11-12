package co.com.sofkau.juegocaballo.application;

import co.com.sofkau.juegocaballo.domain.command.CrearJuegoCommand;
import co.com.sofkau.juegocaballo.domain.command.IniciarJuegoCommand;
import co.com.sofkau.juegocaballo.usecase.IniciarJuegoUseCase;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController

public class JuegoControlador {

    private final IniciarJuegoUseCase useCase;
    private final ApplicationEventPublisher eventPublisher;

    public JuegoControlador(IniciarJuegoUseCase useCase, ApplicationEventPublisher eventPublisher) {
        this.useCase = useCase;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/createGame")
    public void crear(@RequestBody CrearJuegoCommand command){
        this.eventPublisher.publishEvent(command);
        //return useCase.apply(command);
    }


    @PostMapping("/{id}")
    public Object iniciarJuego(@PathVariable String id){
        //this.eventPublisher.publishEvent(command);
        IniciarJuegoCommand command = new IniciarJuegoCommand(id);
        System.out.println("ESTOY AQUI");
        return useCase.apply(command);
    }

}
