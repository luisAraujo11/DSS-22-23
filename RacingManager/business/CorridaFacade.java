package RacingManager.business;

import RacingManager.database.CampeonatoDAO;
import RacingManager.database.CorridaDAO;

import java.util.Map;
import java.util.*;

public class CorridaFacade implements ICorridaFacade{
    private Map<String,Corrida> corridas;

    public CorridaFacade(){
        this.corridas = CorridaDAO.getInstance();
    }

    @Override
    public Corrida getCorrida(Circuito cir){
        Corrida result = null;
        Iterator corridasIterator = this.corridas.entrySet().iterator();
        while(corridasIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)corridasIterator.next();
            Corrida c =(Corrida) mapElement.getKey();
            if (c.getCircuito()==cir) result = c;
        }
        return result;
    }

    @Override
    public Collection<Corrida> getCorridas(){
        return corridas.values();
    }

    
    @Override
    public void adcionaCorrida(Corrida c){
        this.corridas.put(c.getIdCorrida(),c);
    }

    @Override
    public boolean existeCorrida(String idCorrida){
        return corridas.containsKey(idCorrida);
    }

}