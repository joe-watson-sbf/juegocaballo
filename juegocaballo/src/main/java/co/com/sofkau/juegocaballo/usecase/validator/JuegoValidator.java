package co.com.sofkau.juegocaballo.usecase.validator;

import co.com.sofkau.juegocaballo.domain.entity.Juego;

public class JuegoValidator {

    public static void validarCreacionJuego(final Juego juego){

        if(!listaIsOk(juego)){
            throw new IllegalArgumentException("Hay que ingresar minimo 3 Jinetes y " +
                    "maximo 5 para crear un juego!!!");
        }

        if(pistaIsNotOk(juego)){
            throw new IllegalArgumentException("Las cantidades de kilometros deben ser mayor a 0!!!");
        }
    }



    private static boolean listaIsOk(Juego juego){
        return (juego.jinetes().size()>=3 && juego.jinetes().size()<=5);
    }

    private static boolean pistaIsNotOk(Juego juego){
        return (juego.pista()==null || juego.pista().kilometros()<=0);
    }

}
