package co.com.sofkau.juego.application;

import co.com.sofkau.juego.application.model.JuedoIdWeb;
import co.com.sofkau.juego.domain.command.CrearJuegoCommand;
import co.com.sofkau.juego.usecase.CrearJuegoUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EndPointCrearJuego {

    private final CrearJuegoUseCase useCase;

    public EndPointCrearJuego(CrearJuegoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/juego/createGame")
    public JuedoIdWeb crear(@RequestBody CrearJuegoCommand command){
        String idJuegoCreado = useCase.apply(command).id();
        return new JuedoIdWeb(idJuegoCreado);
    }

}
