/**
 * Classe Piloto
 * 
 * @author (Maurício Pereira) 
 * @version (1.0)
 */

import java.io.Serializable;

public class Piloto implements Serializable
{
    //Variaveis de instancia
    private String nome;
    private float cts;
    private float sva;
    
    //Construtores
    public Piloto()
    {
        this.nome = "";
        this.cts = 0;
        this.sva = 0;
    }

    public Piloto(String nome, float cts, float sva) {
        this.nome = nome;
        this.cts = cts;
        this.sva = sva;
    }    
    
    public Piloto(Piloto p)
    {
        this.nome = p.getNome();
        this.cts = p.getCts();
        this.sva = p.getSva();
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCts() {
        return this.cts;
    }

    public void setCts(float cts) {
        this.cts = cts;
    }

    public float getSva() {
        return this.sva;
    }

    public void setSva(float sva) {
        this.sva = sva;
    }
    
    //Metodos usuais
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: "); sb.append(this.nome);
        sb.append("\tCTS: ");sb.append(this.cts);
        sb.append("\tSVA: ");sb.append(this.sva);
        return sb.toString();
    }
    
    public Piloto clone()
    {
        return new Piloto(this);
    }
    
    public boolean equals(Object o)
    {
        if(this == o)
        return true;
        
        if((o == null) || (this.getClass() != o.getClass()))
        return false;
        
        Piloto p = (Piloto) o;
        return (this.nome.equals(p.getNome()) && 
                this.cts==p.getCts() &&
                this.sva==p.getSva());
    }
}
