package co.com.sofkau.juego.domain.command;

import co.com.sofkau.juego.domain.Jinete;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearJuegoCommand implements Serializable {
    private List<Jinete> jinetes;
    private Integer kilometros;

}
