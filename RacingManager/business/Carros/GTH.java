package RacingManager.business.Carros;

import RacingManager.business.Equipa.Equipa;
import RacingManager.business.Metereologia.Meteorologia;

import java.util.Random;
public class GTH extends GT implements Hibrido {

    private int potenciaEletrica;

    public GTH(){
        super();
        this.potenciaEletrica = 0;
    }

    public GTH(String idCarro, String marca, String modelo, String modoMotor, int cilindrada, int potencia, int potenciaEletrica, boolean serHibrido, float fiabilidade, Class classe, float pac, Equipa e){
        super(idCarro,marca,modelo,modoMotor,cilindrada,potencia,serHibrido,fiabilidade,classe,pac,e);
        this.potenciaEletrica = potenciaEletrica;
    }

    public GTH(GTH c){
        super(c);
        this.potenciaEletrica = c.getPotenciaMotorEletrico();
    }

    public GTH clone(){
        return new GTH(this);
    }

    public boolean DNF(int volta, int totalvoltas, Meteorologia meteo)
    {
       Random rand=new Random();
       int x=rand.nextInt(70);
       int motorh = this.getPotenciaMotorEletrico()/20; 
       //no maximo fiabilidade de 85%
       // 3000 cilindrada = 85% / 4500 cilindrada = 57%
       int fiabilidade = (int)((100000/super.getCilindrada())*2.55);
       int desgaste = (int)((volta+1)*0.5); //0.5% a cada volta
       return (x > (fiabilidade - desgaste - motorh));
    }

    @Override
    public int getPotenciaMotorEletrico() {
        return this.potenciaEletrica;
    }

    @Override
    public void setPotenciaMotorEletrico(int potencia) {
        this.potenciaEletrica=potencia;
    }
}

