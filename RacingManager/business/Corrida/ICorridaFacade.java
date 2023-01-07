package RacingManager.business.Corrida;

import RacingManager.business.Circuito.Circuito;

import java.util.Collection;

public interface ICorridaFacade {

    public void adcionaCorrida(Corrida c);

    public boolean existeCorrida(String idCorrida);

    public Corrida getCorrida(Circuito cir);

    public Collection<Corrida> getCorridas();
}
