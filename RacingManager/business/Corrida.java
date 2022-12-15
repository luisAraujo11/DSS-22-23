package RacingManager.business;

public class Corrida {
    private String idCorrida;

    public Corrida(){
        this.idCorrida = null;
    }

    public Corrida(String idCorrida){
        this.idCorrida = idCorrida;
    }

    public Corrida(Corrida c){
        this.idCorrida = c.getCorrida();
    }

    public String getCorrida() {
        return this.idCorrida;
    }

}