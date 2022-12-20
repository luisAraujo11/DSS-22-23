package RacingManager.business;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class Meteorologia implements Serializable{
    private String precipitacao;
    private int temperatura;
    private int idMeteorologia;


    public Meteorologia() {
        this.precipitacao="";
        this.temperatura=0;
        this.idMeteorologia=0;

    }

    public Meteorologia(Meteorologia m) {
        this.precipitacao=m.getPrecipitacao;
        this.temperatura=m.getTemperatura;
        this.idMeteorologia=m.getIdMeteorologia;

    }

    public Meteorologia(String precipitacao, int temperatura, in idMeteorologia) {
        this.precipitacao = precipitacao;
        this.temperatura = temperatura;
        this.idMeteorologia = idMeteorologia;
    }

    public String getPrecipitacao() {
        return this.precipitacao;
    }

    public void setPrecipitacao(String precipitacao) {
        this.precipitacao = precipitacao;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public in getIdMeteorologia() {
        return this.idMeteorologia;
    }

    public void setIdMeteorologia(in idMeteorologia) {
        this.idMeteorologia = idMeteorologia;
    }

    public abstract Meteorologia clone();

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
 
         
         Meteorologia m = (Meteorologia) m;
         return( this.precipitacao == m.getPrecipitacao() &&
                 this.temperatura == m.getTemperatura() &&
                 this.idMeteorologia == m.getIdMeteorologia());
     }
}