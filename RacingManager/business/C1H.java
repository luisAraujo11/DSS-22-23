package RacingManager.business;

public class C1H extends C1 implements Hibrido{

    private int motor_eletrico;

    public C1H(){
        super();
        this.motor_eletrico = 0;
    }

    public C1H(String idCarro, String marca, String modelo, String modoMotor, int cilindrada, int potencia,boolean serHibrido, float fiabilidade, Carro.Class classe, float pac,int eletrico){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,serHibrido,fiabilidade,classe,pac);
        this.motor_eletrico = eletrico;
    }
    
    public C1H(C1H c){
        super(c);
        this.motor_eletrico = c.getPotenciaMotorEletrico();
    }
    
    public C1H clone(){
        return new C1H(this);
    }
    @Override
    public int getPotenciaMotorEletrico() {
        return this.motor_eletrico;
    }

    @Override
    public void setPotenciaMotorEletrico(int potencia) {
        this.motor_eletrico=potencia;
    }
}
