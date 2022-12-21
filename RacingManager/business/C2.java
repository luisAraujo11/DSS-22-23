package RacingManager.business;

import java.util.Random;
public class C2 extends Carro {

    private int afinação;

    public C2(){
        super();
    }
    public C2(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia,boolean serHibrido, float fiabilidade,Class classe, float pac,int afinação,Equipa e){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,false,0,null,0,e);
        this.afinação=afinação;
    }

    public C2(C2 c){
        super(c);
        this.afinação=getAfinação();
    }

    public int getAfinação() {
        return this.afinação;
    }

    public void setAfinação(int afinação) {
        this.afinação = afinação;
    }

    public C2 clone(){
        return new C2(this);
    }

    public boolean DNF(int volta,int totalvoltas,Meteorologia meteo)
    {
       Random rand=new Random();
       int x=rand.nextInt(85);
       float fiabilidade = super.getFiabilidade() + (super.getCilindrada()/1200) + (this.afinação/10);
       return (x > fiabilidade);
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