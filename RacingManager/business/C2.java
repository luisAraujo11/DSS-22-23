package RacingManager.business;

public class C2 extends Carro {

    public C2(){
        super();
    }
    public C2(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia, int potenciaEletrica, boolean serHibrido, float fiabilidade,Class classe, float pac){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,0,false,0,null,0);
    }

    public C2(C2 c){
        super(c);
    }

    public C2 clone(){
        return new C2(this);
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