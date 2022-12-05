import java.util.Map;
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
    private int potenciaEletrica;
    private boolean serHibrido;
    private float fiabilidade;
    private float pac;
    
    /* Construtores */
    public Carro()
    {
        this.idCarro= "";
        this.marca = "";
        this.modelo = "";
        this.modoMotor="";
        this.cilindrada = 0;
        this.potencia = 0;
        this.potenciaEletrica = 0;
        this.serHibrido=null;
        this.fiabilidade = 0;
        this.pac = 0;
    }
    
    public Carro(String idCarro, String marca, String modelo, String modoMotor, int cilindrada, int potencia, int potenciaEletrica, boolean serHibrido, float fiabilidade, float pac;)
    {
        this.idCarro= idCarro;
        this.marca = marca;
        this.modelo = modelo;
        this.modoMotor=modoMotor;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.potenciaEletrica = potenciaEletrica;
        this.serHibrido=serHibrido;
        this.fiabilidade = fiabilidade;
        this.pac = pac;
    }
    
    public Carro(Carro c)
    {
        this.idCarro= c.getIdCarro;
        this.marca = c.getMarca;
        this.modelo = c.getModelo;
        this.modoMotor=c.getModoMotor;
        this.cilindrada = c.getCilindrada;
        this.potencia = c.getPotencia;
        this.potenciaEletrica = c.getPotenciaEletrica
        this.serHibrido=c.getSerHibrido;
        this.fiabilidade = c.getFiabilidade;
        this.pac = c.getPac;
    }
    
    /* Gets e sets */

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

    public int getPotenciaEletrica() {
        return this.potenciaEletrica;
    }

    public void setPotenciaEletrica(int potenciaEletrica) {
        this.potenciaEletrica = potenciaEletrica;
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


    /* Metodos usuais */
    public abstract Carro clone();
    
    public String toString()     
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nIdCarro: ");sb.append(this.idCarro);
        sb.append("\nMarca: ");sb.append(this.marca);
        sb.append("\nModelo: ");sb.append(this.modelo);
        sb.append("\nModoMotor: ");sb.append(this.modoMotor);
        sb.append("\nCilindrada: ");sb.append(this.cilindrada);
        sb.append("\nPotencia: ");sb.append(this.potencia);
        sb.append("\nPotenciaEletrica: ");sb.append(this.potenciaEletrica);
        sb.append("\nHibrido: ");sb.append(this.serHibrido);
        sb.append("\nFiabiliade: ");sb.append(this.fiabilidade);
        sb.append("\nPac: ");sb.append(this.pac);
        return sb.toString();
    }
    
    public boolean equals(Object o)
    {
        if(this==o)
        return true;
        
        if(o==null || this.getClass()!=o.getClass())
        return false;

        private String idCarro;
        private String marca;
        private String modelo;
        private String modoMotor;
        private int cilindrada;
        private int potencia;
        private int potenciaEletrica;
        private boolean serHibrido;
        private float fiabilidade;
        private float pac;
        
        Carro c = (Carro) o;
        return( this.idCarro.equals(c.getIdCarro()) &&
                this.marca.equals(c.getMarca()) &&
                this.modelo.equals(c.getModelo()) &&
                this.modoMotor.equals(c.getModoMotor) &&
                this.cilindrada == c.getCilindrada() &&
                this.potencia == c.getPotencia() &&
                this.potenciaEletrica == c.getPotenciaEletrica() &&
                this.serHibrido == c.getSerHibrido() &&
                this.fiabilidade == c.getFiabilidade() &&
                this.pac == c.getPac());
    }
    