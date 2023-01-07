package RacingManager.business.Campeonato;

import RacingManager.business.Circuito.Circuito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Campeonato here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

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
        this.nome="";
        this.circuitos = new ArrayList<Circuito>();
    }

    public Campeonato(String nomeCamp)
    {
        this.nome=nomeCamp;
        this.circuitos = new ArrayList<Circuito>();
    }

    public Campeonato(String nome, List<Circuito> circuitos) {
        this.nome = nome;
        ArrayList<Circuito> aux= new ArrayList<Circuito>();
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

    public void addCircuito(Circuito c)
    {
        this.circuitos.add(c);
    }

    public Circuito getCircuito(int x)
    {
        return this.circuitos.get(x-1);
    }

    public Campeonato clone(){
        return new Campeonato(this);
    }
}
