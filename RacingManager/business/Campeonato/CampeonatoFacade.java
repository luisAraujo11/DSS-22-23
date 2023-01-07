package RacingManager.business.Campeonato;

import RacingManager.business.Circuito.Circuito;
import RacingManager.database.CampeonatoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CampeonatoFacade implements ICampeonatoFacade {
    private Map<String, Campeonato> campeonatos;
    private Map<String, Campeonato> pilotos;

    public CampeonatoFacade() throws SQLException {
        this.campeonatos = CampeonatoDAO.getInstance();
        this.pilotos = new HashMap<>();
    }

    public CampeonatoFacade(String nomeCamp) throws SQLException {
        this.campeonatos = CampeonatoDAO.getInstance();
        this.pilotos = new HashMap<>();
    }


    /*
    @Override
    public ArrayList<String> getCampeonatos() {

        ArrayList<String> aux = new ArrayList<>();
        for (String c : aux){
            aux = this.campeonatos.getAll();
            }
        return aux;
        }
    */


    /*
    public ArrayList<Campeonato> getAll(){

        ArrayList<Campeonato> res = new ArrayList<>();
        int i = campeonatos.size();
        while (i>0){
            System.out.println(this.campeonatos.values().toString());
            i--;
        }

        /*for(Map.Entry<String, Campeonato> set : this.campeonatos.entrySet()){
            res.add(getCampeonato(String.valueOf(set.getValue())));
        }

        return null;
    }
    */
    public void PilotoClear(){
        pilotos.clear();
    }

    @Override
    public Campeonato getCampeonato(String nome){
        return this.campeonatos.get(nome);
    }

    public boolean validaCampeonato(String nomeCap){
        return this.campeonatos.containsValue(nomeCap);
    }


    @Override
    public void adicionaCampeonato(Campeonato c){
        this.campeonatos.put(c.getNome(),c);
    }

    @Override
    public Collection<Campeonato> getCampeonatos() {
        return this.campeonatos.values();
        //for(Map.Entry<String,Campeonato> entry: campeonatos.entrySet()){
        //    System.out.println(entry.getKey()+ " : " + entry.getValue());
        //
    }


    @Override
    public ArrayList<Circuito> getCircuitos(Campeonato champ){
        return champ.getCircuitos();
    }

}

