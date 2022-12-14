package RacingManager.business;

public class C1{

    public C1(){
        super();
    }
    public C1(int potencia, int potenciaEletrica, boolean serHibrido, String modoMotor){
        super(potencia,potenciaEletrica,serHibrido,modoMotor);
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
}