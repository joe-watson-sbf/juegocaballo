package co.com.sofkau.juego.infrastructure.documentos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class JineteDocumento {

    @Id
    private String id;
    private String nombre;
    private String colorCaballo;
    private Integer distancia;
}
