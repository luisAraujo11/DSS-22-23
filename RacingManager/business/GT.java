package RacingManager.business;

import java.util.Random;
public class GT extends Carro {

    public GT(){
        super();
    }
    public GT(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia, boolean serHibrido, float fiabilidade,Class classe, float pac,Equipa e){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,false,0,null,0,e);
    }

    public GT(GT c){
        super(c);
    }

    public GT clone(){
        return new GT(this);
    }

    public boolean DNF(int volta,int totalvoltas,Meteorologia meteo)
    {
       Random rand=new Random();
       int x=rand.nextInt(70);
       //no maximo fiabilidade de 85%
       // 3000 cilindrada = 85% / 4500 cilindrada = 57%
       int fiabilidade = (int)((100000/super.getCilindrada())*2.55);
       int desgaste = (int)((volta+1)*0.5); //0.5% a cada volta
       return (x > (fiabilidade - desgaste));
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