package co.com.sofkau.juegocaballo.infrastructure.utils;

import co.com.sofkau.juegocaballo.domain.entity.Jinete;
import co.com.sofkau.juegocaballo.domain.entity.Juego;
import co.com.sofkau.juegocaballo.domain.entity.Pista;
import co.com.sofkau.juegocaballo.domain.entity.Podio;
import co.com.sofkau.juegocaballo.infrastructure.model.JineteDocumento;
import co.com.sofkau.juegocaballo.infrastructure.model.JuegoDocumento;
import co.com.sofkau.juegocaballo.infrastructure.model.PistaDocumento;
import co.com.sofkau.juegocaballo.infrastructure.model.PodioDocumento;

import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {

    public static Juego toJuego(JuegoDocumento documento){
        return Juego.builder()
                .jinetes(toSetJinete(documento.getJinetes()))
                .pista(documento.getPista())
                .podio(documento.getPodioDocumento())
                .id(documento.getId())
                .build();
    }

    public static JuegoDocumento toDocumento(Juego juego){
        var doc = new JuegoDocumento();
        doc.setJinetes( toSetJineteDocumento(juego.jinetes()));
        doc.setId(juego.id());
        doc.setPistaDocumento(juego.pista());
        doc.setPodio(juego.podio());
        doc.setJugando(juego.jugando());
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

    private static Set<Jinete> toSetJinete(Set<JineteDocumento> jinetes){
        return jinetes
                .stream().map(Mapper::toJinete)
                .collect(Collectors.toSet());
    }


    public static JineteDocumento toJineteDocumento(Jinete jinete){
        JineteDocumento documento = new JineteDocumento();
        documento.setId(jinete.id());
        documento.setNombre(jinete.nombre());
        documento.setDistancia(jinete.distancia());
        documento.setColorCaballo(jinete.colorCaballo());
        return documento;
    }

    private static Set<JineteDocumento> toSetJineteDocumento(Set<Jinete> jinetes){
        return jinetes
                .stream().map(Mapper::toJineteDocumento)
                .collect(Collectors.toSet());
    }

    public static Pista toPista(PistaDocumento documento){
        return Pista.PistaBuilder.aPista()
                .withKilometros(documento.getKilometros())
                .withNumeroCarriles(documento.getNumeroCarriles())
                .build();
    }

    public static PistaDocumento toPistaDocumento(Pista pista){
        var doc = new PistaDocumento();
        doc.setKilometros(pista.kilometros());
        doc.setNumeroCarriles(pista.numeroCarriles());
        return doc;
    }

    public static Podio toPodio(PodioDocumento documento){
        return Podio.PodioBuilder.aPodio()
                .withPrimerLugar(toJinete(documento.getPrimerLugar()))
                .withSegundoLugar(toJinete(documento.getSegundoLugar()))
                .withTercerLugar(toJinete(documento.getTercerLugar()))
                .build();
    }

    public static PodioDocumento toPodioDocumento(Podio podio){
        var doc = new PodioDocumento();

        doc.setPrimerLugar(toJineteDocumento(podio.primerLugar()));
        doc.setSegundoLugar(toJineteDocumento(podio.segundoLugar()));
        doc.setTercerLugar(toJineteDocumento(podio.tercerLugar()));

        return doc;
    }
}
