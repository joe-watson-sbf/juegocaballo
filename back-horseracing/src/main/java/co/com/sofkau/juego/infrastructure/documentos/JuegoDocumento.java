package co.com.sofkau.juego.infrastructure.documentos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document
public class JuegoDocumento {
    @Id
    private String id;
    private List<JineteDocumento> jinetes;
    private Integer kilometros;
    private Integer numeroCariles;
}
