package RacingManager.business.Circuito;

import RacingManager.business.Equipa.Piloto;
import RacingManager.business.Record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Circuito implements Serializable {

    private String nome;
    private float tamanhoCircuito;
    private int numerodeVoltas;
    ArrayList<SectoresCircuito> sectoresCircuito;

    public Circuito(String nome, float tamanhoCircuito, int numerodeVoltas, List<SectoresCircuito> sectoresCircuito) {
        this.nome = nome;
        this.tamanhoCircuito = tamanhoCircuito;
        this.numerodeVoltas = numerodeVoltas;
        this.sectoresCircuito = new ArrayList<>();
        for (SectoresCircuito c:sectoresCircuito)
            this.sectoresCircuito.add(c.clone());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public float getTamanhoCircuito() {
        return tamanhoCircuito;
    }

    public void setTamanhoCircuito(float circuitLength) {
        this.tamanhoCircuito = circuitLength;
    }

    public int getNumerodeVoltas() {
        return numerodeVoltas;
    }

    public void setNumerodeVoltas(int numberOfLaps) {
        this.numerodeVoltas = numberOfLaps;
    }

    public ArrayList<SectoresCircuito> getSectoresCircuito() {
        ArrayList<SectoresCircuito> t=new ArrayList<>();
        for (SectoresCircuito c:sectoresCircuito)
            t.add(c.clone());
        return t;
    }

    public void setSectoresCircuito(ArrayList<SectoresCircuito> circuitSections) {
        this.sectoresCircuito = new ArrayList<>();
        for (SectoresCircuito c:circuitSections)
            this.sectoresCircuito.add(c.clone());
    }

    public Map<String, Long> getTemposMedios() {
        return null;
    }

    public long getTempoDesvio() {
        return 0;
    }

    public int getVoltas() {
        return 0;
    }

    public Piloto getRecord() {
        return null;
    }

    public Record setRecord(Record r) {
        return r;
    }

    public String toString() {
        return nome;
    }

}
/*public class Circuito implements Serializable {

    private String nome;
    private int distancia;
    private int curvas;
    private int chicane;
    private int voltas;
    private GDU gdu;
    private Record record;

    public Map<String, Long> getTemposMedios() {
        HashMap<String,Long> aux = new HashMap<String, Long>();
        return aux;
    }

    public long getTempoDesvio() {
        return 1;
    }

    public enum GDU{
        Dificl,
        Possivel,
        Impossivel
    }

    public Circuito() {
        this.nome="";
        this.distancia=0;
        this.curvas=0;
        this.chicane=0;
        this.voltas=0;
        this.gdu=null;
        this.record = null;

    }

    public Circuito(String nome, int distancia, int curvas, int chicane, int voltas, GDU gdu, Record r) {
        this.nome = nome;
        this.distancia = distancia;
        this.curvas = curvas;
        this.chicane = chicane;
        this.voltas = voltas;
        this.gdu= gdu;
        this.record = r.clone();
    }

    public Circuito(Circuito c) {
        this.nome=c.getNome();
        this.distancia=c.getDistancia();
        this.curvas=c.getCurvas();
        this.chicane=c.getChicane();
        this.voltas=c.getVoltas();
        this.gdu=c.getGdu();
        this.record=c.getRecord();

    }

    public Record getRecord() { return this.record.clone(); }
    public void setRecord(Record r) { this.record = r.clone(); }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getCurvas() {
        return curvas;
    }

    public void setCurvas(int curvas) {
        this.curvas = curvas;
    }

    public int getChicane() {
        return chicane;
    }

    public void setChicane(int chicane) {
        this.chicane = chicane;
    }

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }

    public GDU getGdu() {
        return gdu;
    }

    public void setGdu(GDU gdu) {
        this.gdu = gdu;
    }

    public Circuito clone()
    {
        return new Circuito(this);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ");sb.append(this.nome);
        sb.append("\nDistancia: ");sb.append(this.distancia);
        sb.append("\nCurvas: ");sb.append(this.curvas);
        sb.append("\nChicane: ");sb.append(this.chicane);
        sb.append("\nNumero de voltas: ");sb.append(this.voltas);
        sb.append("\nGDU: ");sb.append(this.gdu);
        return sb.toString();
    }

    public boolean equals(Object o)
    {
        if(this == o)
            return true;

        if(o == null || this.getClass() != o.getClass())
            return false;

        Circuito c = (Circuito) o;
        return ( this.nome.equals(c.getNome()) &&
                this.distancia == c.getDistancia() &&
                this.curvas==c.getCurvas() &&
                this.voltas == c.getVoltas() &&
                this.chicane==c.getChicane() &&
                this.gdu==c.getGdu());
    }

}
*/