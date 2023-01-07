package RacingManager.business.Campeonato;

import RacingManager.business.Circuito.Circuito;
import RacingManager.database.CampeonatoDAO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;

public class CampeonatoFacade implements ICampeonatoFacade {
    private Map<String, Campeonato> campeonatos;

    public CampeonatoFacade() throws SQLException {
        this.campeonatos = CampeonatoDAO.getInstance();
    }

    public CampeonatoFacade(String nomeCamp) throws SQLException {
        this.campeonatos = CampeonatoDAO.getInstance();
    }
/*
    @Override
    public ArrayList<String> getCampeonatos() {

        ArrayList<String> aux = new ArrayList<>();
        for (String c : aux){
            aux = this.campeonatos.getAll();
            }
        return aux;
        }*/



    @Override
    public Campeonato getCampeonato(String nome){
        Campeonato result =new Campeonato();
        result = null;
        Collection<Campeonato> camp;
        camp = getCampeonatos();
        for (Campeonato c: camp){
            if(c.getNome().equals(nome)) result = c;
        }
        return result;
    }

    @Override
    public void adicionaCampeonato(Campeonato c){
        this.campeonatos.put(c.getNome(),c);
    }

    @Override
    public Collection<Campeonato> getCampeonatos() {
        return null;
    }

    @Override
    public ArrayList<Circuito> getCircuitos(Campeonato champ){
        return champ.getCircuitos();
    }

}

