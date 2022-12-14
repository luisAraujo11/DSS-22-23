package RacingManager.business;

import java.io.Serializable;

public abstract class Jogador implements Comparable<Carro>,Serializable{
    //Variaveis de instancia
    private String registo;
    private int pontuacao;
    private Carro carro;
    private Piloto piloto;

    
    /* Construtores */
    public Jogador(){
        this.registo = null;
        this.pontuacao = 0;
        this.carro = null;
        this.piloto = null;
    }
    
    public Jogador(String registo, int pontuacao, Carro carro, Piloto piloto){
        this.registo = registo;
        this.pontuacao = pontuacao;
        this.carro = carro;
        this.piloto = piloto;
    }

    public Jogador(Jogador j){
        this.registo = j.getRegisto();
        this.pontuacao = j.getPontuacao();
        this.carro = j.getCarro();
        this.piloto = j.getPiloto(); 
    }


    /* Gets e sets */

    //registo
    public String getRegisto() {
        return this.registo;
    }

    public void setRegisto(String registo) {
        this.registo = registo;
    }

    //pontuacao
    public int getPontuacao() {
        return this.pontuacao;
    }
    public void setMarca(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    //Carro
    public Carro getCarro(){
        return this.carro;
    }

    public void setCarro(Carro Carro){
        this.carro = carro;
    }

    //Piloto
    public Piloto getPiloto(){
        return this.piloto;
    }

    public void setPiloto(Piloto piloto){
        this.piloto = piloto;
    }

    /* Metodos usuais */
    public abstract Jogador clone();
    
    //toString
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nRegisto: ");sb.append(this.registo);
        sb.append("\nPontuacao: ");sb.append(this.pontuacao);
        sb.append("\nCarro: ");sb.append(this.carro);
        sb.append("\nPiloto: ");sb.append(this.piloto);

        return sb.toString();
    }

    //Equals
    public boolean equals(Object o){
        if(this==o)
        return true;
        
        if(o==null || this.getClass()!=o.getClass()){
            return false;
        } 
           
    
        Jogador j = (Jogador) o;
        return( this.registo.equals(j.getRegisto()) &&
                this.pontuacao == (j.getPontuacao()) &&
                this.carro.equals(j.getCarro()) &&
                this.piloto.equals(j.getPiloto()));
    }

}
    
