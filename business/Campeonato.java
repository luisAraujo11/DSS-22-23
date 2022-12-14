
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedList;
import java.io.Serializable;

public class Campeonato implements Serializable
{

    private String nome;
    private List<Circuito> circuitos;

    public Campeonato()
    {
        this.nome=""
        this.circuitos = new ArrayList<Circuito>();
    }

    public Campeonato(String nome, List<Circuito> circuitos) {
        this.nome = " ";
        this();
        ArrayList<Circuito> aux= new ArrayList<Circuito>();
        for(Circuito circuitos : circuitos)
        {
            aux.add(circuitos.clone());
        }
        this.corridas = aux;
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


    public List<Corrida> getCircuitos()
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

    public Corrida getCircuito(int x)
    {
        return this.circuitos.get(x-1).clone();
    }

}
