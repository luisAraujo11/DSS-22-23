package RacingManager.business;

public class C2H extends C2 implements Hibrido{

    private int potenciaEletrica;

    public C2H(){
        super();
        this.potenciaEletrica = 0;
    }

    public C2H(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia, int potenciaEletrica, boolean serHibrido, float fiabilidade,Class classe, float pac){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,potenciaEletrica,serHibrido,fiabilidade,classe,pac);
        this.potenciaEletrica = potenciaEletrica;
    }

    public C2H(C2H c){
        super(c);
        this.potenciaEletrica = c.getPotenciaEletrica();
    }

    public C2H clone(){
        return new C2H(this);
    }
    @Override
    public int getPotenciaMotorEletrico() {
        return 0;
    }

    @Override
    public void setPotenciaMotorEletrico(int potencia) {

    }
}

