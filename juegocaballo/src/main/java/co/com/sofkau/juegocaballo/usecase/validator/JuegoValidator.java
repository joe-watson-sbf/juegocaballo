package co.com.sofkau.juegocaballo.usecase.validator;

import co.com.sofkau.juegocaballo.domain.entity.Jinete;
import co.com.sofkau.juegocaballo.domain.entity.Juego;

import java.util.Objects;

public class JuegoValidator {

    public static void validarCreacionJuego(final Juego juego){

        if(!listaIsOk(juego)){
            throw new IllegalArgumentException("Hay que ingresar minimo 3 Jinetes y " +
                    "maximo 5 para crear un juego!!!");
        }

        if(pistaIsNotOk(juego)){
            throw new IllegalArgumentException("Las cantidades de kilometros deben ser mayor a 0!!!");
        }
        validarJinetes(juego);
    }

    private static void validarJinetes(Juego juego){
        juego.jinetes()
                .forEach(JuegoValidator::nonNullDataJinete);
    }

    private static void nonNullDataJinete(Jinete jinete){

        if(jinete.nombre().isBlank()){
            throw new IllegalArgumentException("Nombre del jinete no puede ser vacio!!!");
        }
        if(jinete.colorCaballo().isBlank()){
            throw new IllegalArgumentException("Color del caballo es obligatorio!!!");
        }
    }



    private static boolean listaIsOk(Juego juego){
        return (juego.jinetes().size()>=3 && juego.jinetes().size()<=5);
    }

    private static boolean pistaIsNotOk(Juego juego){
        return (juego.pista()==null || juego.pista().kilometros()<=0);
    }

}
