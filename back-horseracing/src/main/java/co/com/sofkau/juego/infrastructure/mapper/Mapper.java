package co.com.sofkau.juego.infrastructure.mapper;

import co.com.sofkau.juego.domain.Jinete;
import co.com.sofkau.juego.domain.Juego;
import co.com.sofkau.juego.infrastructure.documentos.JineteDocumento;
import co.com.sofkau.juego.infrastructure.documentos.JuegoDocumento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public static JineteDocumento toJineteDocumento(Jinete jinete){
        return new JineteDocumento(
                jinete.id(),
                jinete.nombre(),
                jinete.colorCaballo(),
                jinete.distancia()
        );
    }

    public static  Jinete toJinete(JineteDocumento documento){
        return Jinete.builder()
                .id(documento.getId())
                .nombre(documento.getNombre())
                .colorCaballo(documento.getColorCaballo())
                .distancia(documento.getDistancia())
                .build();
    }

    public static  List<JineteDocumento> toDocumentoJineteList(List<Jinete> jinetes){
        return jinetes.stream().map(Mapper::toJineteDocumento)
                .collect(Collectors.toList());
    }

    public static  List<Jinete> toJineteList(List<JineteDocumento> documentoList){
        return documentoList.stream().map(Mapper::toJinete)
                .collect(Collectors.toList());
    }

    public static Juego toJuego(JuegoDocumento documento){
        return Juego.builder()
                .id(documento.getId())
                .kilometros(documento.getKilometros())
                .jinetes(toJineteList(documento.getJinetes()))
                .build();
    }

}
