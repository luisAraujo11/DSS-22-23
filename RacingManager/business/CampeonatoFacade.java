package RacingManager.business;

import RacingManager.database.CampeonatoDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CampeonatoFacade implements ICampeonatoFacade{
    private Map<String,Campeonato> campeonatos;


    public CampeonatoFacade(){
        this.campeonatos = CampeonatoDAO.getInstance();
        this.campeonatos = new HashMap<>();
    }


    @Override
    public Collection <Campeonato> getCampeonatos(){
        return campeonatos.values();
    }

    @Override
    public Campeonato getCampeonato(String nome){
        Campeonato result =null;
        Collection<Campeonato> camp;
        camp = getCampeonatos();
        for (Campeonato c: camp){
            if(c.equals(nome)) result = c;
        }
        return result;
    }

    @Override
    public Campeonato getCampeonato2(String nomeCamp){
        if(campeonatos.containsKey(nomeCamp)) return campeonatos.get(nomeCamp);
        else return null;
    }

    @Override
    public void adicionaCampeonato(Campeonato c){
        this.campeonatos.put(c.getNome(),c);
    }


    @Override
    public boolean existeCampeonato(String nomeCamp){
        return campeonatos.containsKey(nomeCamp);
    }



}

