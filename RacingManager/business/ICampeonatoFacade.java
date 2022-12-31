package RacingManager.business;

import java.util.Collection;
import java.util.ArrayList;

public interface ICampeonatoFacade {
    void adicionaCampeonato(Campeonato c);

    Collection<Campeonato> getCampeonatos();

    public Campeonato getCampeonato(String nome);

    public ArrayList<Circuito> getCircuitos(Campeonato champ);
}
