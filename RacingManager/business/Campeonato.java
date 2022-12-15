package RacingManager.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Campeonato implements Serializable
{

    private String nome;
    private List<Circuito> circuitos;

    public Campeonato(String nomeCamp)
    {
        this.nome="";
        this.circuitos = new ArrayList<Circuito>();
    }

    public Campeonato(String nome, List<Circuito> circuitos) {
        this.nome = "";
        ArrayList<Circuito> aux= new ArrayList<Circuito>();
        for(Circuito cir : circuitos)
        {
            aux.add(cir.clone());
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
            aux.add(ci.clone());
        }
        return aux;
    }

    public void addCircuito(Circuito c)
    {
        this.circuitos.add(c.clone());
    }

    public Circuito getCircuito(int x)
    {
        return this.circuitos.get(x-1).clone();
    }

    public Campeonato clone(){
        return new Campeonato(this);
    }
}
