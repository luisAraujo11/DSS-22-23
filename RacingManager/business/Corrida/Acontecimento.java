package RacingManager.business.Corrida;

import java.io.Serializable;

public class Acontecimento implements Serializable {

    private boolean dnf;
    private boolean ultrapassagem;

   public Acontecimento(){
       this.dnf = false;
       this.ultrapassagem=false;
   }

   public boolean getDnf(){
       return this.dnf;
   }

   public boolean getUltrapassagem(){
       return this.ultrapassagem;
   }

   public void setDnf(Boolean dnf){
       this.dnf=dnf;
   }

   public void setUltrapassagem(Boolean ultrapassagem){
       this.ultrapassagem=ultrapassagem;
   }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nDNF: ");sb.append(this.dnf);
        sb.append("\nUltrapassagem: ");sb.append(this.ultrapassagem);

        return sb.toString();
    }
}
