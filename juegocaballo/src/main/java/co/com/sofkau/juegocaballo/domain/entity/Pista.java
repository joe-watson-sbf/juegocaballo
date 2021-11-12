package co.com.sofkau.juegocaballo.domain.entity;

public class Pista {
    private Integer kilometros;
    private Integer numeroCarriles;

    public Pista(Integer kilometros, Integer numeroCarriles) {
        this.kilometros = kilometros;
        this.numeroCarriles = numeroCarriles;
    }


    public static final class PistaBuilder {
        private Integer kilometros;
        private Integer numeroCarriles;

        private PistaBuilder() {
        }

        public static PistaBuilder aPista() {
            return new PistaBuilder();
        }

        public PistaBuilder withKilometros(Integer kilometros) {
            this.kilometros = kilometros;
            return this;
        }

        public PistaBuilder withNumeroCarriles(Integer numeroCarriles) {
            this.numeroCarriles = numeroCarriles;
            return this;
        }

        public Pista build() {
            return new Pista(kilometros, numeroCarriles);
        }
    }



    public Integer kilometros() {
        return kilometros;
    }

    public void kilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public Integer numeroCarriles() {
        return numeroCarriles;
    }

    public void numeroCarriles(Integer numeroCarriles) {
        this.numeroCarriles = numeroCarriles;
    }

    @Override
    public String toString() {
        return "{" +
                "kilometros:" + kilometros +
                ", numeroCarriles:" + numeroCarriles +
                '}';
    }



}
