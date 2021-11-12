package co.com.sofkau.juegocaballo.domain.entity;

import java.util.Random;

public class Jinete {
    private String id;
    private String nombre;
    private String colorCaballo;
    private Integer distancia;

    public Jinete(String nombre, String colorCaballo) {
        this.id = null;
        this.nombre = nombre;
        this.colorCaballo = colorCaballo;
        this.distancia = 0;
    }


    public static final class JineteBuilder {
        private String id;
        private String nombre;
        private String colorCaballo;
        private Integer distancia;

        private JineteBuilder() {
        }

        public static JineteBuilder aJinete() {
            return new JineteBuilder();
        }

        public JineteBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public JineteBuilder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public JineteBuilder withColorCaballo(String colorCaballo) {
            this.colorCaballo = colorCaballo;
            return this;
        }

        public JineteBuilder withDistancia(Integer distancia) {
            this.distancia = distancia;
            return this;
        }

        public Jinete build() {
            Jinete jinete = new Jinete(nombre, colorCaballo);
            jinete.id = this.id;
            jinete.distancia = this.distancia;
            return jinete;
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
        return "{" +
                "id:'" + id + '\'' +
                ", nombre:'" + nombre + '\'' +
                ", colorCaballo:'" + colorCaballo + '\'' +
                ", distancia:" + distancia +
                '}';
    }


}
