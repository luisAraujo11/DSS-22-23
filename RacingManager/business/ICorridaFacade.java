package RacingManager.business;

import java.util.*;

public interface ICorridaFacade {

    public void adcionaCorrida(Corrida c);

    public boolean existeCorrida(String idCorrida);

    public Corrida getCorrida(Circuito cir);

    public Collection<Corrida> getCorridas();
}
