package co.com.sofkau.juego.domain;

import java.util.Random;

public class Jinete {
    private String id;
    private String nombre;
    private String colorCaballo;
    private Integer distancia;

    public Jinete(String id, String nombre, String colorCaballo) {
        this.id = id;
        this.nombre = nombre;
        this.colorCaballo = colorCaballo;
        this.distancia = 0;
    }

    public static JineteBuilder builder() {
        return new JineteBuilder();
    }

    public static final class JineteBuilder {
        private String id;
        private String nombre;
        private String colorCaballo;
        private Integer distancia;

        private JineteBuilder() {
        }

        public JineteBuilder id(String id) {
            this.id = id;
            return this;
        }

        public JineteBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public JineteBuilder colorCaballo(String colorCaballo) {
            this.colorCaballo = colorCaballo;
            return this;
        }

        public Integer distancia() {
            return distancia;
        }

        public JineteBuilder distancia(Integer distancia) {
            this.distancia = distancia;
            return this;
        }

        public Jinete build() {
            return new Jinete(id, nombre, colorCaballo);
        }
    }


    public void avanzar(){
        this.distancia += lanzarDado();
    }

    private Integer lanzarDado(){
        Random random = new Random();
        int dado = random.nextInt(6);
        return dado > 0 ? (dado * 100) : 100;
    }

    public boolean alcanzarLaMeta(Integer kilometos){
        int metros = kilometos * 1000;
        return this.distancia>=metros;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public String nombre() {
        return nombre;
    }

    public void nombre(String nombre) {
        this.nombre = nombre;
    }

    public String colorCaballo() {
        return colorCaballo;
    }

    public void colorCaballo(String colorCaballo) {
        this.colorCaballo = colorCaballo;
    }

    public Integer distancia() {
        return distancia;
    }

    public void distancia(Integer distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        String json = "{ \"id\": \"IDJINETE\"," +
                " \"nombre\": \"NOMBREJINETE\", " +
                "\"colorCaballo\": \"COLORCABALLO\"," +
                " \"distancia\": DISTANCIA }";

        json = json.replaceAll("IDJINETE", id);
        json = json.replaceAll("NOMBREJINETE", nombre);
        json = json.replaceAll("COLORCABALLO", colorCaballo);
        json = json.replaceAll("DISTANCIA", distancia.toString());

        return json;
    }

}
