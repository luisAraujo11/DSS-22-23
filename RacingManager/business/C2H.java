package RacingManager.business;


import java.util.Random;
public class C2H extends C2 implements Hibrido{

    private int potenciaEletrica;

    public C2H(){
        super();
        this.potenciaEletrica = 0;
    }

    public C2H(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia, int potenciaEletrica, boolean serHibrido, float fiabilidade,Class classe, float pac,int afinação,Equipa e){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,serHibrido,fiabilidade,classe,pac,afinação,e);
        this.potenciaEletrica = potenciaEletrica;
    }

    public C2H(C2H c){
        super(c);
        this.potenciaEletrica = c.getPotenciaMotorEletrico();
    }

    public C2H clone(){
        return new C2H(this);
    }

    @Override
    public String toString() {
        String s =  super.toString();
        return(s + "Motor Eletrico: " + this.getPotenciaMotorEletrico() + "\n" );
    }

    public boolean DNF(int volta,int totalvoltas,Meteorologia meteo)
    {
       Random rand=new Random();
       int x=rand.nextInt(85);
       int motorh = this.getPotenciaMotorEletrico()/20;
       //no maximo fiabilidade de 85%
       float fiabilidade = super.getFiabilidade() + (super.getCilindrada()/1200) + (super.getAfinação()/10);
       return (x > (fiabilidade-motorh));
    }
    @Override
    public int getPotenciaMotorEletrico() {
        return this.potenciaEletrica;
    }

    @Override
    public void setPotenciaMotorEletrico(int potencia) {
        this.potenciaEletrica=potencia;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        C2H c = (C2H) o;
        return (c.getPotenciaMotorEletrico() == this.getPotenciaMotorEletrico() && super.equals(o));
    }


}

