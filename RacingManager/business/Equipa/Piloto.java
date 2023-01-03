package RacingManager.business.Equipa;

import RacingManager.business.Carros.Carro;
import RacingManager.business.Circuito.Circuito;
import RacingManager.business.Metereologia.Meteorologia;

import java.io.Serializable;
import java.util.Map;

public class Piloto implements Serializable
{
    //Variaveis de instancia
    private String nome;
    private boolean dnf;
    private float cts;
    private float sva;
    private long tempo;
    
    //Construtores
    public Piloto()
    {
        this.nome = "";
        this.cts = 0;
        this.sva = 0;
        this.tempo = 0;
    }

    public Piloto(String nome,boolean dnf, float cts, float sva, long tempo, Piloto p1, Piloto p2) {
        this.nome = nome;
        this.dnf=dnf;
        this.cts = cts;
        this.sva = sva;
        this.tempo = tempo;
    }    
    
    public Piloto(Piloto p)
    {
        this.nome = p.getNome();
        this.dnf=p.getDnf();
        this.cts = p.getCts();
        this.sva = p.getSva();
        this.tempo = p.getTempo();
    }


    public boolean getDnf() {
        return this.dnf;
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    public void setDnf(boolean dnf) {
        this.dnf = dnf;
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


    public long tempoProximaVolta(Circuito c, Meteorologia meteo, int volta) {
        Carro carro = new Carro() {
            @Override
            public int compareTo(Carro o) {
                return 0;
            }
        };

            Map<String, Long> aux = c.getTemposMedios();
            long t_medio = aux.get(this.getClass().getName());
            long t_chuva = c.getTempoDesvio();
            long minimum = 0;
            long maximum = 5000;
            long fator_sorte = minimum + Double.valueOf(Math.random() * (maximum - minimum)).intValue();
            long maximum_chuva = 2000;
            long fator_sorte_chuva = minimum + Double.valueOf(Math.random() * (maximum_chuva - minimum)).intValue();

            if (volta < (c.getVoltas() / 2)) {
                /* usa piloto 1*/
                return (t_medio + ((carro.getCilindrada() / carro.getPotencia())) * 1000L) - fator_sorte
                        + ((meteo.getPrecipitacao()+meteo.getTemperatura()) * (t_chuva * 1000)) - fator_sorte_chuva;
            } else {
                /*usa piloto 2*/
                if (volta == (c.getVoltas() / 2)) {
                    return (t_medio + ((carro.getCilindrada() / carro.getPotencia())) * 1000L) - fator_sorte
                            + ((meteo.getPrecipitacao()+meteo.getTemperatura()) * (t_chuva * 1000)) - fator_sorte_chuva;
                } else
                    return (t_medio + ((carro.getCilindrada() / carro.getPotencia())) * 1000L) - fator_sorte
                            + ((meteo.getPrecipitacao()+meteo.getTemperatura()) * (t_chuva  * 1000)) - fator_sorte_chuva;
            }
        }


    //Metodos usuais
    public String toString()
    {
        String sb = "\nNome: " + this.nome +
                "\nDNF " + this.dnf +
                "\tCTS: " + this.cts +
                "\tSVA: " + this.sva;
        return sb;
    }
    
    public Piloto clone()
    {
        return new Piloto(this);
    }
    
    public boolean equals(Object o) {
        if(this == o) return true;
        
        if((o == null) || (this.getClass() != o.getClass())) return false;
        
        Piloto p = (Piloto) o;
        return (this.nome.equals(p.getNome()) &&
                this.dnf== p.getDnf() && 
                this.cts==p.getCts() &&
                this.sva==p.getSva());
    }

    public boolean DNF(int volta, int totalvoltas, Meteorologia meteorologia) { // TODO verificar se isto faz sentido
        return false;
    }
}
