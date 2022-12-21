package RacingManager.business;

import java.util.Random;

public class C1 extends Carro {

    public C1(){
        super();
    }
    public C1(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia,boolean serHibrido, float fiabilidade,Class classe, float pac,Equipa e){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,false,0,null,0,e);
    }

    public C1(C1 c){
        super(c);
    }

    public C1 clone(){
        return new C1(this);
    }

    public boolean DNF(int volta,int totalvoltas,Meteorologia meteo)
    {
       Random rand=new Random();
       int x=rand.nextInt(87);
       return (x > super.getFiabilidade());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Carro o) {
        return 0;
    }
}