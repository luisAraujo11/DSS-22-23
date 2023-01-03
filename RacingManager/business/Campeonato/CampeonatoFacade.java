package RacingManager.business.Campeonato;

import RacingManager.business.Circuito.Circuito;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class CampeonatoFacade implements ICampeonatoFacade {
    private Map<String, Campeonato> campeonatos;


    public CampeonatoFacade(){
        this.campeonatos = new HashMap<>();
    }


    @Override
    public Collection <Campeonato> getCampeonatos(){
        return campeonatos.values();
    }

    @Override
    public Campeonato getCampeonato(String nome){
        Campeonato result =new Campeonato();
        result = null;
        Collection<Campeonato> camp;
        camp = getCampeonatos();
        for (Campeonato c: camp){
            if(c.getNome().equals(nome)) result = c;
        }
        return result;
    }

    @Override
    public void adicionaCampeonato(Campeonato c){
        this.campeonatos.put(c.getNome(),c);
    }

    @Override
    public ArrayList<Circuito> getCircuitos(Campeonato champ){
        return champ.getCircuitos();
    }

}

