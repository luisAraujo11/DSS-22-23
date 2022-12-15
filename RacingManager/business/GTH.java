package RacingManager.business;

public class GTH extends GT implements Hibrido{

    private int potenciaEletrica;

    public GTH(){
        super();
        this.potenciaEletrica = 0;
    }

    public GTH(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia, int potenciaEletrica, boolean serHibrido, float fiabilidade,Class classe, float pac){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,serHibrido,fiabilidade,classe,pac);
        this.potenciaEletrica = potenciaEletrica;
    }

    public GTH(GTH c){
        super(c);
        this.potenciaEletrica = c.getPotenciaMotorEletrico();
    }

    public GTH clone(){
        return new GTH(this);
    }
    @Override
    public int getPotenciaMotorEletrico() {
        return this.potenciaEletrica;
    }

    @Override
    public void setPotenciaMotorEletrico(int potencia) {
        this.potenciaEletrica=potencia;
    }
}

