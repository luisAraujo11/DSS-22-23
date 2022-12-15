package RacingManager.business;

import java.util.Collection;

public interface ICorridaFacade {

    public Collection<Corrida> getCampeonatos();

    public void adcionaCampeonato(Corrida c);

    public boolean existeCorrida(String idCorrida);
}
