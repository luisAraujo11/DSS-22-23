package RacingManager.business.Metereologia;

import java.io.Serializable;

public class Meteorologia implements Serializable{
    private int precipitacao;
    private int temperatura;
    private int idMeteorologia;


    public Meteorologia() {
        this.precipitacao=0;
        this.temperatura=0;
        this.idMeteorologia=0;

    }

    public Meteorologia(Meteorologia m) {
        this.precipitacao=m.getPrecipitacao();
        this.temperatura=m.getTemperatura();
        this.idMeteorologia=m.getIdMeteorologia();

    }

    public Meteorologia(int precipitacao, int temperatura, int idMeteorologia) {
        this.precipitacao = precipitacao;
        this.temperatura = temperatura;
        this.idMeteorologia = idMeteorologia;
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

    public int getIdMeteorologia() {
        return this.idMeteorologia;
    }

    public void setIdMeteorologia(int idMeteorologia) {
        this.idMeteorologia = idMeteorologia;
    }

    public String toString()     
     {
         StringBuilder sb = new StringBuilder();
         sb.append("\nPrecipitacao: ");sb.append(this.precipitacao);
         sb.append("\nTemperatura: ");sb.append(this.temperatura);
         sb.append("\nidMeteorologia: ");sb.append(this.idMeteorologia);
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
                this.temperatura == m.getTemperatura() &&
                this.idMeteorologia == m.getIdMeteorologia());
     }
}