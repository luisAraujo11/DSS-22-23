package RacingManager.business;

import RacingManager.database.CampeonatoDAO;
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
    public void adicionaCampeonato(Campeonato c){
        this.campeonatos.put(c.getNome(),c);
    }


    @Override
    public boolean existeCampeonato(String nomeCamp){
        return campeonatos.containsKey(nomeCamp);
    }
}

