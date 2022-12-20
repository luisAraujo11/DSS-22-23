package RacingManager.business;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class Corrida implements Serializable{

    private String idCorrida;
    private Circuito circuito;
    private List<Piloto> listaPilotos;
    private Map<Piloto, Boolean> dnf;
    private Meteorologia meteo;

    public Corrida(){
        this.idCorrida = null;
    }

    public Corrida(String idCorrida,Circuito circuito,List<Piloto> listaPilotos,Map<Piloto, Boolean> dnf,Meteorologia meteo){
        this.idCorrida = idCorrida;
        this.circuito=circuito;
        this.listaPilotos=listaPilotos;
        this.dnf=dnf;
        this.meteo=meteo;
    }

    public Corrida(Corrida c){
        this.idCorrida = c.getIdCorrida();
        this.circuito=getCircuito();
        this.listaPilotos=getListaPilotos();
        this.dnf=getDnf();
        this.meteo=getMeteo();
    }

    public Meteorologia getMeteo() {
        return this.meteo;
    }

    public void setMeteo(Meteorologia meteo) {
        this.meteo = meteo;
    }

    public String getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(String idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public ArrayList<Piloto> getListaPilotos()
    {
        ArrayList<Piloto> aux = new ArrayList<Piloto>();
        for(Piloto p : this.listaPilotos)
        {
            aux.add(p.clone());
        }
        return aux;
    }

    public void setListaPilotos(List<Piloto> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public Map<Piloto,Boolean> getDnf() {

        Map<Piloto,Boolean> dnfs= new HashMap<Piloto,Boolean>();
        for(Map.Entry<Piloto, Boolean> set : dnf.entrySet()){
            dnfs.put(set.getKey(),set.getValue());
        }
        return dnfs;
    }


    public void setDnf(Map<Piloto, Boolean> dnf) {
        this.dnf = dnf;
    }

    public void simulaCorrida()
    {
        int voltas = this.circuito.getVoltas();
        long t_aux, t_volta;
        ArrayList<Piloto> aux = new ArrayList<Piloto>();
        HashMap<Piloto,Integer> temp = new HashMap<Piloto,Integer>();
        for(Piloto p : this.listaPilotos)
        {
            aux.add(p.clone());
        }
        for(int i=0; i<voltas; i++)
        {
            for(Piloto p : aux)
            {
                if(p.getDnf()==false) //verifica se o carro esta acidentado
                {
                    if(p.DNF(i,voltas,this.meteo)==true) //verifica se o carro tem acidente na volta
                    {
                        p.setDnf(true);
                        temp.put(p.clone(),i);
                    }
                    else
                    {
                       t_aux = p.getTempo(); //tempo feito ate ao momento
                       if(c instanceof Hibrido)
                       {
                           Hibrido h = (Hibrido)c;
                           int motor = h.getPotenciaMotorEletrico();
                           t_volta = c.tempoProximaVolta(this.circuito, 0, i) - motor*10;
                       }
                       else
                            t_volta = c.tempoProximaVolta(this.circuito, 0, i);
                       c.setTempo(t_aux +t_volta); 
                       //atualizar record
                       if(this.circuito.getRecord().getTempo() > t_volta)
                       {
                           if(i<(this.circuito.getVoltas()/2))
                           {
                                Record r = new Record(t_volta,c.getEquipa().getPiloto1(),c.clone());
                                this.circuito.setRecord(r);
                           }
                           else
                           {
                               Record r = new Record(t_volta,c.getEquipa().getPiloto2(),c.clone());
                               this.circuito.setRecord(r);
                           }
                       }
                    }
                }
            }
            this.primeiroVolta(i,aux); //metodo auxiliar para determinar o 1º a cada volta
        }
        for(Piloto p : aux)
        {
            if(p.getDnf()==false)
            {
                    this.resultados.add(p);
            }
        }
        this.dnf = temp;
    }
}