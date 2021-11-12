package co.com.sofkau.juegocaballo.infrastructure.utils;

import co.com.sofkau.juegocaballo.domain.entity.Jinete;
import co.com.sofkau.juegocaballo.domain.entity.Juego;
import co.com.sofkau.juegocaballo.domain.entity.Podio;
import co.com.sofkau.juegocaballo.infrastructure.model.JineteDocumento;
import co.com.sofkau.juegocaballo.infrastructure.model.JuegoDocumento;

import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {

    public static Juego toJuego(JuegoDocumento documento){
        return Juego.builder()
                .jinetes(documento.getJinetes())
                .pista(documento.getPista())
                .id(documento.getId())
                .build();
    }

    public static JuegoDocumento toDocumento(Juego juego){
        var doc = new JuegoDocumento();
        doc.setJinetes(juego.jinetes());
        doc.setId(juego.id());
        doc.setPista(juego.pista());
        doc.setPodio(juego.podio());
        return doc;
    }

    public static Jinete toJinete(JineteDocumento documento){
        return Jinete.JineteBuilder.aJinete()
                .withId(documento.getId())
                .withNombre(documento.getNombre())
                .withDistancia(documento.getDistancia())
                .withColorCaballo(documento.getColorCaballo())
                .build();
    }

    private static Set<Jinete> set(Set<JineteDocumento> jinetes){
        return jinetes
                .stream().map(Mapper::toJinete)
                .collect(Collectors.toSet());
    }
}
