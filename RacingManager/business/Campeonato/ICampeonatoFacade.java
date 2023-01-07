package RacingManager.business.Campeonato;

import RacingManager.business.Circuito.Circuito;

import java.util.Collection;
import java.util.ArrayList;

public interface ICampeonatoFacade {

    void adicionaCampeonato(Campeonato c);

    Collection<Campeonato> getCampeonatos();

    Campeonato getCampeonato(String nome);

    ArrayList<Circuito> getCircuitos(Campeonato champ);

}
