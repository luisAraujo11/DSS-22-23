package RacingManager.business.Campeonato;

import RacingManager.business.Circuito.Circuito;
import RacingManager.business.Equipa.Piloto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Campeonato implements Serializable
{

    private String nome;
    private List<Circuito> circuitos;
    private Map<Piloto,Integer> pontuacaoGeral;

    public Campeonato()
    {
        this.nome="";
        //this.circuitos = new ArravyList<Circuito>();
        this.pontuacaoGeral = new HashMap<Piloto,Integer>();
    }

    public Campeonato(String nomeCamp)
    {
        this.nome=nomeCamp;
        this.circuitos = new ArrayList<Circuito>();
        this.pontuacaoGeral = new HashMap<Piloto, Integer>();
    }

    public Campeonato(String nome, List<Circuito> circuitos) {
        this.nome = nome;
       List<Circuito> aux= new ArrayList<Circuito>();
        for(Circuito cir : circuitos)
        {
            aux.add(cir);
        }
        this.circuitos = aux;
    }


    public Campeonato(Campeonato c)
    {
        this.nome=c.getNome();
        this.circuitos = c.getCircuitos();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Campeonato{" +
                "nome='" + nome + '\'' +
                ", circuitos=" + circuitos +
                '}';
    }

    public ArrayList<Circuito> getCircuitos()
    {
        ArrayList<Circuito> aux = new ArrayList<Circuito>();
        for(Circuito ci : this.circuitos)
        {
            aux.add(ci);
        }
        return aux;
    }
    public Map<Piloto,Integer> getPontuacaoGeral(){

        Map<Piloto,Integer> aux = new HashMap<>();
        for(Map.Entry<Piloto, Integer> set : pontuacaoGeral.entrySet()){
            aux.put(set.getKey(),set.getValue());
        }
        return aux;
    }

    public void setPontuacaoGeral(Map<Piloto,Integer> pontucao){
        for(Map.Entry<Piloto, Integer> set : pontucao.entrySet()){
            this.pontuacaoGeral.put(set.getKey(),set.getValue());
        }
    }

    // public Map<Piloto,Boolean> getDnf() {
    //
    //        Map<Piloto,Boolean> dnfs= new HashMap<>();
    //        for(Map.Entry<Piloto, Boolean> set : dnf.entrySet()){
    //            dnfs.put(set.getKey(),set.getValue());
    //        }
    //        return dnfs;
    //    }

    public void addCircuito(Circuito c)
    {
        this.circuitos.add(c);
    }


    public Circuito getCircuito(int x)
    {
        return this.circuitos.get(x-1);
    }

    public boolean existeCorrida(Circuito cir){
        return false;
    }

    public Campeonato clone(){
        return new Campeonato(this);
    }
}
