package co.com.sofkau.juegocaballo.application;

import co.com.sofkau.juegocaballo.domain.command.CrearJuegoCommand;
import co.com.sofkau.juegocaballo.domain.command.IniciarJuegoCommand;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JuegoControlador {

    private final ApplicationEventPublisher eventPublisher;

    public JuegoControlador(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/createGame")
    public void crear(@RequestBody CrearJuegoCommand command){
        this.eventPublisher.publishEvent(command);
    }


    @PostMapping("/inciarjuego")
    public void iniciarJuego(@RequestBody IniciarJuegoCommand command){
        this.eventPublisher.publishEvent(command);
    }

}
