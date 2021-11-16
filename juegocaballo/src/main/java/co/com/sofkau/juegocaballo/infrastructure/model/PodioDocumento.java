package co.com.sofkau.juegocaballo.infrastructure.model;

public class PodioDocumento {
    private JineteDocumento primerLugar;
    private JineteDocumento segundoLugar;
    private JineteDocumento tercerLugar;

    public PodioDocumento() {
    }

    public JineteDocumento getPrimerLugar() {
        return primerLugar;
    }

    public void setPrimerLugar(JineteDocumento primerLugar) {
        this.primerLugar = primerLugar;
    }

    public JineteDocumento getSegundoLugar() {
        return segundoLugar;
    }

    public void setSegundoLugar(JineteDocumento segundoLugar) {
        this.segundoLugar = segundoLugar;
    }

    public JineteDocumento getTercerLugar() {
        return tercerLugar;
    }

    public void setTercerLugar(JineteDocumento tercerLugar) {
        this.tercerLugar = tercerLugar;
    }


}
