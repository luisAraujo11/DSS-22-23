package RacingManager.business;

import java.util.Collection;

public interface ICampeonatoFacade {
    void adicionaCampeonato(Campeonato c);

    boolean existeCampeonato(String nomeCamp);

    Collection<Campeonato> getCampeonatos();

    public Campeonato getCampeonato(String nome);

    public Campeonato getCampeonato2(String nomeCamp);
}
