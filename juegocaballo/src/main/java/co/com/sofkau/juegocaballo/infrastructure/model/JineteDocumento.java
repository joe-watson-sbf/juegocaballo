package co.com.sofkau.juegocaballo.infrastructure.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JineteDocumento {
    private String id;
    private String nombre;
    private String colorCaballo;
    private Integer distancia;

    public JineteDocumento() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColorCaballo() {
        return colorCaballo;
    }

    public void setColorCaballo(String colorCaballo) {
        this.colorCaballo = colorCaballo;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
}
