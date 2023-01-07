package RacingManager.business.Campeonato;

import RacingManager.business.Circuito.Circuito;

import java.util.ArrayList;
import java.util.Collection;

public interface ICampeonatoFacade {

    void adicionaCampeonato(Campeonato c);

    public void PilotoClear();
    Collection<Campeonato> getCampeonatos();

    Campeonato getCampeonato(String nome);

    ArrayList<Circuito> getCircuitos(Campeonato champ);

    //public ArrayList<Campeonato> getAll();

}
