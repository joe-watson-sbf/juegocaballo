package co.com.sofkau.juegocaballo.domain.entity;

import java.util.List;

public class Podio {
    private Jinete primerLugar;
    private Jinete segundoLugar;
    private Jinete tercerLugar;

    public Podio(){
        this.primerLugar=null;
        this.segundoLugar=null;
        this.tercerLugar = null;
    }


    public static final class PodioBuilder {
        private Jinete primerLugar;
        private Jinete segundoLugar;
        private Jinete tercerLugar;

        private PodioBuilder() {
        }

        public static PodioBuilder aPodio() {
            return new PodioBuilder();
        }

        public PodioBuilder withPrimerLugar(Jinete primerLugar) {
            this.primerLugar = primerLugar;
            return this;
        }

        public PodioBuilder withSegundoLugar(Jinete segundoLugar) {
            this.segundoLugar = segundoLugar;
            return this;
        }

        public PodioBuilder withTercerLugar(Jinete tercerLugar) {
            this.tercerLugar = tercerLugar;
            return this;
        }

        public Podio build() {
            Podio podio = new Podio();
            podio.tercerLugar = this.tercerLugar;
            podio.primerLugar = this.primerLugar;
            podio.segundoLugar = this.segundoLugar;
            return podio;
        }
    }


    public void definirPuestos(List<Jinete> ganadores){
        PodioBuilder.aPodio().withPrimerLugar(ganadores.get(0)).build();
        PodioBuilder.aPodio().withSegundoLugar(ganadores.get(1)).build();
        PodioBuilder.aPodio().withTercerLugar(ganadores.get(2)).build();
    }

    public Jinete primerLugar() {
        return primerLugar;
    }

    public Jinete segundoLugar() {
        return segundoLugar;
    }

    public Jinete tercerLugar() {
        return tercerLugar;
    }

    @Override
    public String toString() {
        return "{" +
                "primerLugar:" + primerLugar +
                ", segundoLugar:" + segundoLugar +
                ", tercerLugar:" + tercerLugar +
                '}';
    }


}
