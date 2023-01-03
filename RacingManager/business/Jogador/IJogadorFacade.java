package RacingManager.business.Jogador;

import java.util.Collection;

public interface IJogadorFacade {
    public Collection<Jogador> getJogadores();

    public void adcionaJogador(Jogador j);

    public boolean existeJogador(String nomeJog);
}
