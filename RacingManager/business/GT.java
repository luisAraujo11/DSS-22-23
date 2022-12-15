package RacingManager.business;

public class GT extends Carro {

    public GT(){
        super();
    }
    public GT(String idCarro, String marca, String modelo,String modoMotor, int cilindrada, int potencia, boolean serHibrido, float fiabilidade,Class classe, float pac){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,false,0,null,0);
    }

    public GT(GT c){
        super(c);
    }

    public GT clone(){
        return new GT(this);
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