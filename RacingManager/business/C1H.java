package RacingManager.business;

import java.util.Random;
public class C1H extends C1 implements Hibrido{

    private int motor_eletrico;

    public C1H(){
        super();
        this.motor_eletrico = 0;
    }

    public C1H(String idCarro, String marca, String modelo, String modoMotor, int cilindrada, int potencia,boolean serHibrido, float fiabilidade, Carro.Class classe, float pac,int eletrico,Equipa e){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,serHibrido,fiabilidade,classe,pac,e);
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
    public String toString()
    {
        String s =  super.toString();
        return(s + "Motor Eletrico: " + this.getPotenciaMotorEletrico()+ "\n" );
    }

    public boolean DNF(int volta,int totalvoltas,Meteorologia meteo)
    {
       Random rand=new Random();
       int x=rand.nextInt(87);
       int motorh = this.getPotenciaMotorEletrico()/20;
       return (x > (super.getFiabilidade()-motorh));
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        C1H c = (C1H) o;
        return (c.getPotenciaMotorEletrico() == this.getPotenciaMotorEletrico() && super.equals(o));
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
