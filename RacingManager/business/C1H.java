package RacingManager.business;

public class C1H extends C1 implements Hibrido{

    private int potenciaEletrica;

    public C1H(){
        super();
        this.potenciaEletrica = 0;
    }

    public C1H(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia, int potenciaEletrica, boolean serHibrido, float fiabilidade,Class classe, float pac){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,potenciaEletrica,serHibrido,fiabilidade,classe,pac);
        this.potenciaEletrica = potenciaEletrica;
    }
    
    public C1H(C1H c){
        super(c);
        this.potenciaEletrica = c.getPotenciaEletrica();
    }
    
    public C1H clone(){
        return new C1H(this);
    }
    @Override
    public int getPotenciaMotorEletrico() {
        return 0;
    }

    @Override
    public void setPotenciaMotorEletrico(int potencia) {

    }
}
