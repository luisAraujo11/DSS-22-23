package RacingManager.business;

import java.util.Collection;
import java.util.ArrayList;

public interface ICampeonatoFacade {
    void adicionaCampeonato(Campeonato c);

    boolean existeCampeonato(String nomeCamp);

    Collection<Campeonato> getCampeonatos();

    public Campeonato getCampeonato(String nome);

    public Campeonato getCampeonato2(String nomeCamp);

    public ArrayList<Circuito> getCircuitos(Campeonato champ);
}
