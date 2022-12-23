package RacingManager.business;

import java.io.Serializable;
 
 public abstract class Carro implements Comparable<Carro>,Serializable
 {
     //Variaveis de instancia
     private String idCarro;
     private String marca;
     private String modelo;
     private String modoMotor;
     private int cilindrada;
     private int potencia;
     private boolean serHibrido;
     private float fiabilidade;
     private Class classe;
     private float pac;
     private tipoPneu pneus;
     private Equipa equipa;
    	private float downforce;

     public enum Class{
         C1,
         C2,
         GT,
         SC
     }
     
     /* Construtores */
     public Carro()
     {
         this.idCarro= "";
         this.marca = "";
         this.modelo = "";
         this.modoMotor="";
         this.cilindrada = 0;
         this.potencia = 0;
         this.serHibrido=false;
         this.fiabilidade = 0;
         this.classe=null;
         this.pac = 0;
         this.equipa=new Equipa();
     }
     
     public Carro(String idCarro, String marca, String modelo, String modoMotor, int cilindrada, int potencia,boolean serHibrido, float fiabilidade,Class classe, float pac,Equipa e)
     {
         this.idCarro= idCarro;
         this.marca = marca;
         this.modelo = modelo;
         this.modoMotor=modoMotor;
         this.cilindrada = cilindrada;
         this.potencia = potencia;
         this.serHibrido=serHibrido;
         this.fiabilidade = fiabilidade;
         this.classe=classe;
         this.pac = pac;
         this.equipa=e.clone();

     }
     
     public Carro(Carro c)
     {
         this.idCarro= c.getIdCarro();
         this.marca = c.getMarca();
         this.modelo = c.getModelo();
         this.modoMotor=c.getModoMotor();
         this.cilindrada = c.getCilindrada();
         this.potencia = c.getPotencia();
         this.serHibrido=c.getSerHibrido();
         this.fiabilidade = c.getFiabilidade();
         this.classe=c.getClasse();
         this.pac = c.getPac();
         this.equipa=c.getEquipa();
     }
     
     /* Gets e sets */

    public Equipa getEquipa() {
        return this.equipa.clone();
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa.clone();
    }
 
     public String getMarca() {
         return this.marca;
     }
 
     public void setMarca(String marca) {
         this.marca = marca;
     }
 
     public String getModelo() {
         return this.modelo;
     }
 
     public void setModelo(String modelo) {
         this.modelo = modelo;
     }
 
     public int getCilindrada() {
         return this.cilindrada;
     }
 
     public void setCilindrada(int cilindrada) {
         this.cilindrada = cilindrada;
     }
 
     public int getPotencia() {
         return this.potencia;
     }
 
     public void setPotencia(int potencia) {
         this.potencia = potencia;
     }
 
     public float getFiabilidade() {
         return this.fiabilidade;
     }
 
 
     public Class getClasse() {
         return this.classe;
     }
 
     public void setClasse(Class classe) {
         this.classe = classe;
     }
 
     public String getIdCarro() {
         return this.idCarro;
     }
 
     public void setIdCarro(String idCarro) {
         this.idCarro = idCarro;
     }
 
     public String getModoMotor() {
         return this.modoMotor;
     }
 
     public void setModoMotor(String modoMotor) {
         this.modoMotor = modoMotor;
     }
 
     public boolean isSerHibrido() {
         return this.serHibrido;
     }
 
     public boolean getSerHibrido() {
         return this.serHibrido;
     }
 
     public void setSerHibrido(boolean serHibrido) {
         this.serHibrido = serHibrido;
     }
     public void setFiabilidade(float fiabilidade) {
         this.fiabilidade = fiabilidade;
     }
 
     public float getPac() {
         return this.pac;
     }
 
     public void setPac(float pac) {
         this.pac = pac;
     }
 
     
     public String toString()     
     {
         StringBuilder sb = new StringBuilder();
         sb.append("\nIdCarro: ");sb.append(this.idCarro);
         sb.append("\nMarca: ");sb.append(this.marca);
         sb.append("\nModelo: ");sb.append(this.modelo);
         sb.append("\nModoMotor: ");sb.append(this.modoMotor);
         sb.append("\nCilindrada: ");sb.append(this.cilindrada);
         sb.append("\nPotencia: ");sb.append(this.potencia);
         sb.append("\nHibrido: ");sb.append(this.serHibrido);
         sb.append("\nFiabiliade: ");sb.append(this.fiabilidade);
         sb.append("\nClasse: ");sb.append(this.classe);
         sb.append("\nPac: ");sb.append(this.pac);
         sb.append("\nEquipa ");sb.append(this.equipa);
         return sb.toString();
     }
     
     public boolean equals(Object o) {
         if(this==o) return true;
         if(o==null || this.getClass()!=o.getClass()) return false;

         Carro c = (Carro) o;
         return( this.idCarro.equals(c.getIdCarro()) &&
                 this.marca.equals(c.getMarca()) &&
                 this.modelo.equals(c.getModelo()) &&
                 this.modoMotor.equals(c.getModoMotor()) &&
                 this.cilindrada == c.getCilindrada() &&
                 this.potencia == c.getPotencia() &&
                 this.serHibrido == c.getSerHibrido() &&
                 this.fiabilidade == c.getFiabilidade() &&
                 this.classe == c.getClasse() &&
                 this.pac == c.getPac() &&
                 this.equipa.equals(c.getEquipa()));
     }

     public Carro clone()
     {
         return new Carro(this) {
             @Override
             public int compareTo(Carro o) {
                 return 0;
             }
         };
     }

 }
     
