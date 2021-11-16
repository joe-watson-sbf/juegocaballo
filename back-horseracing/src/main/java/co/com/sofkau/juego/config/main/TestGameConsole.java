package co.com.sofkau.juego.config.main;

import co.com.sofkau.juego.domain.Jinete;
import co.com.sofkau.juego.domain.Juego;

import java.util.List;
import java.util.UUID;

public class TestGameConsole {

    public static void main(String[] args) throws InterruptedException {

        Jinete jinete1 = Jinete.builder()
                .id(UUID.randomUUID().toString())
                .nombre("Joe Watson SBF")
                .colorCaballo("RED")
                .build();
        Jinete jinete2 = Jinete.builder()
                .id(UUID.randomUUID().toString())
                .nombre("CARDY")
                .colorCaballo("WHITE")
                .build();
        Jinete jinete3 = Jinete.builder()
                .id(UUID.randomUUID().toString())
                .nombre("LOVE")
                .colorCaballo("YELLOW")
                .build();
        Jinete jinete4 = Jinete.builder()
                .id(UUID.randomUUID().toString())
                .nombre("MIKE")
                .colorCaballo("BLACK")
                .build();

        List<Jinete> map = List.of( jinete1, jinete2, jinete3, jinete4);


        Juego juego = Juego.builder()
                .id(UUID.randomUUID().toString())
                .jinetes(map)
                .kilometros(4)
                .build();


        System.out.println("\nGAME START\n");
        juego.iniciar();

        while (juego.jugando()){
            juego.moverCabbalos();
            System.out.println("\n\tJuego Status");
            juego.jinetes().forEach(System.out::println);
            Thread.sleep(1000);
        }

        System.out.println("\n\nJUEGO TERMINADO\n\n");
        System.out.println("\t\tGANADORES");
        juego.ganadores().forEach((puesto, jinete) -> {
            System.out.println(puesto + "° puesto : " + jinete);
        });

        System.out.println("\nTHANKS\n");

    }
}
