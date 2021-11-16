package co.com.sofkau.juego.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IniciarJuegoCommand implements Serializable {
    private String juegoId;

}
