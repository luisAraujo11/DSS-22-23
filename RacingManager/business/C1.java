package RacingManager.business;

public class C1 extends Carro {

    public C1(){
        super();
    }
    public C1(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia,boolean serHibrido, float fiabilidade,Class classe, float pac){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,false,0,null,0);
    }

    public C1(C1 c){
        super(c);
    }

    public C1 clone(){
        return new C1(this);
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