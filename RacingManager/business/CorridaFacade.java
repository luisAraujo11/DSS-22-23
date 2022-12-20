package RacingManager.business;

import RacingManager.database.CampeonatoDAO;
import RacingManager.database.CorridaDAO;

import java.util.Collection;
import java.util.Map;

public class CorridaFacade implements ICorridaFacade{
    private Map<String,Corrida> corridas;

    public CorridaFacade(){
        this.corridas = CorridaDAO.getInstance();
    }

    @Override
    public Collection <Corrida> getCampeonatos(){
        return corridas.values();
    }
    @Override
    public void adcionaCampeonato(Corrida c){
        this.corridas.put(c.getIdCorrida(),c);
    }

    @Override
    public boolean existeCorrida(String idCorrida){
        return corridas.containsKey(idCorrida);
    }
}