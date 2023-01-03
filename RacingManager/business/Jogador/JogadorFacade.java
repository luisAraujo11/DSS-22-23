package RacingManager.business.Jogador;

import RacingManager.business.Jogador.Jogador;
import RacingManager.database.JogadorDAO;
import java.util.Collection;
import java.util.Map;

public class JogadorFacade implements IJogadorFacade {
    private Map<String, Jogador> jogadores;

    public JogadorFacade(){
        this.jogadores = JogadorDAO.getInstance();
    }

    @Override
    public Collection <Jogador> getJogadores(){
        return jogadores.values();
    }

    @Override
    public void adcionaJogador(Jogador j){
        this.jogadores.put(j.getRegisto(),j);
    }

    @Override
    public boolean existeJogador(String nomeJog){
        return jogadores.containsKey(nomeJog);
    }
}