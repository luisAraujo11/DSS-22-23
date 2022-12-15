package RacingManager.business;

import java.util.Collection;

public interface ICampeonatoFacade {
    void adicionaCampeonato(Campeonato c);

    boolean existeCampeonato(String nomeCamp);

    Collection<Campeonato> getCampeonatos();
}
