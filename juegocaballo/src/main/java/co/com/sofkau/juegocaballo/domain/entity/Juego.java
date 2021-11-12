package co.com.sofkau.juegocaballo.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Juego {

    private final String id;
    private final Set<Jinete> jinetes;
    private final List<Jinete> ganadores;
    private Podio podio;
    private final Pista pista;
    private Boolean jugando;

    private Juego(String id, Set<Jinete> jinetes, Podio podio, Pista pista) {
        this.id = id;
        this.jinetes = jinetes;
        this.ganadores = new ArrayList<>();
        this.podio = podio;
        this.pista = pista;
        this.jugando = false;
    }

    public static JuegoBuilder builder(){
        return new JuegoBuilder();
    }


    public static class JuegoBuilder{
        private String id;
        private Set<Jinete> jinetes;
        private Podio podio;
        private Pista pista;

        JuegoBuilder(){}

        public JuegoBuilder id(final String id){
            this.id = id;
            return this;
        }

        public JuegoBuilder jinetes(final Set<Jinete> jinetes){
            this.jinetes = jinetes;
            return this;
        }


        public JuegoBuilder pista(final Pista pista){
            this.pista = pista;
            return this;
        }

        public JuegoBuilder podio(final Podio podio){
            this.podio = podio;
            return this;
        }

        public Juego build(){
            return new Juego(id, jinetes, podio, pista);
        }

    }




    public void iniciar(){
        this.jugando = true;
    }

    public void obtenerGanadores(){
        moverCabbalos();
    }

    public void moverCabbalos(){
        if(jugando) jinetes.forEach(jinete -> {
            jinete.avanzar();
            verificaAlcanzaLaMeta(jinete);
        });
    }

    private void verificaAlcanzaLaMeta(Jinete jinete){
        if(jinete.alcanzarLaMeta(this.pista.kilometros())) asignarPuesto(jinete);
    }

    private void asignarPuesto(Jinete jinete){
        if(ganadores.size()<3){
            asignarGanador(jinete);
        }
        if (ganadores.size()==3) {
            definirPuestos();
            jugando=false;
        }
    }

    private void definirPuestos(){
        podio = Podio.PodioBuilder.aPodio()
                .withPrimerLugar(ganadores.get(0))
                .withSegundoLugar(ganadores.get(1))
                .withTercerLugar(ganadores.get(2)).build();
    }

    private void asignarGanador(Jinete jinete){
        boolean verification = ganadores.contains(jinete);
        if(!verification){
            ganadores.add(jinete);
        }
    }


    public String id() {
        return id;
    }


    public Set<Jinete> jinetes() {
        return jinetes;
    }


    public Podio podio() {
        return podio;
    }

    public Pista pista() {
        return pista;
    }


    public Boolean jugando() {
        return jugando;
    }

    public void jugando(Boolean jugando) {
        this.jugando = jugando;
    }

    @Override
    public String toString() {
        return "{" +
                "id:'" + id + '\'' +
                ", jinetes:" + jinetes +
                ", podio:" + podio +
                ", pista:" + pista +
                ", jugando:" + jugando +
                '}';
    }
}
