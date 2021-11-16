package co.com.sofkau.juego.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Juego {
    private String id;
    private List<Jinete> jinetes;
    private Map<Integer, Jinete> ganadores;
    private Integer kilometros;
    private Integer numeroCariles;
    private Boolean jugando;

    private Juego(String id, List<Jinete> jinetes, Integer kilometros) {
        this.id = id;
        this.jinetes = jinetes;
        this.ganadores = new HashMap<>();
        this.kilometros = kilometros;
        this.numeroCariles = jinetes.size();
        this.jugando = false;
    }

    public static JuegoBuilder builder() {
        return new JuegoBuilder();
    }

    public static final class JuegoBuilder {
        private String id;
        private List<Jinete> jinetes;
        private Integer kilometros;

        private JuegoBuilder() {
        }

        public JuegoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public JuegoBuilder jinetes(List<Jinete> jinetes) {
            this.jinetes = jinetes;
            return this;
        }

        public JuegoBuilder kilometros(Integer kilometros) {
            this.kilometros = kilometros;
            return this;
        }

        public Juego build() {
            return new Juego(id, jinetes, kilometros);
        }
    }


    public void iniciar(){
        this.jugando = true;
    }


    public void moverCabbalos(){
        if(jugando) jinetes.forEach(jinete -> {
            jinete.avanzar();
            verificaAlcanzaLaMeta(jinete);
        });
    }

    private void verificaAlcanzaLaMeta(Jinete jinete){
        if(jinete.alcanzarLaMeta(kilometros)) asignarPuesto(jinete);
    }

    private void asignarPuesto(Jinete jinete){

        if(ganadores.size()<3){
            if(!ganadores.containsValue(jinete))  asignarGanador(jinete);
        }
        if (ganadores.size()==3) {
            jugando=false;
        }
    }

    private void asignarGanador(Jinete jinete){
        boolean estaEnLista = ganadores.containsValue(jinete);
        if(!estaEnLista){
            int puesto = ganadores.size()+1;
            ganadores.put(puesto, jinete);
        }
    }

    private Jinete obtenerJinetePorId(String id){
        return jinetes.stream().filter(jinete -> jinete.id().equals(id))
                .findFirst().orElse(null);
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public List<Jinete> jinetes() {
        return jinetes;
    }

    public void jinetes(List<Jinete> jinetes) {
        this.jinetes = jinetes;
    }

    public Map<Integer, Jinete> ganadores() {
        return ganadores;
    }

    public void ganadores(Map<Integer, Jinete> ganadores) {
        this.ganadores = ganadores;
    }

    public Integer kilometros() {
        return kilometros;
    }

    public void kilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public Integer numeroCariles() {
        return numeroCariles;
    }

    public void numeroCariles(Integer numeroCariles) {
        this.numeroCariles = numeroCariles;
    }

    public Boolean jugando() {
        return jugando;
    }

    public void jugando(Boolean jugando) {
        this.jugando = jugando;
    }

    private String getPodio(){

        String json = "{ \"primerLugar\": PRIMERO , " +
                "\"segundoLugar\": SEGUNDO, " +
                "\"tercerLugar\": TERCERO }";

        if(ganadores.size()==3 && !jugando){
            json = json.replaceAll("PRIMERO", String.valueOf(ganadores.get(1)));
            json = json.replaceAll("SEGUNDO", String.valueOf(ganadores.get(2)));
            json = json.replaceAll("TERCERO", String.valueOf(ganadores.get(3)));
            return json;
        }
        return "null";
    }

    public String toJSON(){

        String json = "{ \"jugando\": \"ID\", " +
                "\"jugando\": JUGANDO , " +
                "\"podio\": PODIO, " +
                "\"jinetes\": JINETES }";

        json = json.replaceAll("ID", String.valueOf(id));
        json = json.replaceAll("JUGANDO", String.valueOf(jugando));
        json = json.replaceAll("PODIO", getPodio());
        json = json.replaceAll("JINETES", String.valueOf(jinetes));

        return json;
    }

}
