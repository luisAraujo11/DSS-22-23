package RacingManager.business.Metereologia;

import java.io.Serializable;
import java.util.Random;

public class Meteorologia implements Serializable{
    private int precipitacao;
    private int temperatura;


    public Meteorologia() {
        Random r = new Random();
        this.precipitacao = r.nextInt(100);
        this.temperatura = r.nextInt(30);
    }

    public Meteorologia(Meteorologia m) {
        this.precipitacao=m.getPrecipitacao();
        this.temperatura=m.getTemperatura();


    }

    public Meteorologia(int precipitacao, int temperatura, int idMeteorologia) {
        this.precipitacao = precipitacao;
        this.temperatura = temperatura;

    }

    public int getPrecipitacao() {
        return this.precipitacao;
    }

    public void setPrecipitacao(int precipitacao) {
        this.precipitacao = precipitacao;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }





    public String toString()     
     {
         StringBuilder sb = new StringBuilder();
         sb.append("\nPrecipitacao: ");sb.append(this.precipitacao);
         sb.append("\nTemperatura: ");sb.append(this.temperatura);

         return sb.toString();
     }
     
     public boolean equals(Object o)
     {
         if(this==o)
         return true;
         
         if(o==null || this.getClass()!=o.getClass())
         return false;
 
         
        Meteorologia m = (Meteorologia) o;
        return( this.precipitacao == m.getPrecipitacao() &&
                this.temperatura == m.getTemperatura());
     }
}