package RacingManager.database;

import RacingManager.business.Campeonato.Campeonato;
import RacingManager.business.Jogador.Jogador;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class JogadorDAO implements Map<String, Jogador> {

    private static JogadorDAO singleton = null;

    private JogadorDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);


             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Jogadores (" +
                    "Registo varchar(10) NOT NULL PRIMARY KEY," +
                    "Pontuacao int(4) DEFAULT 0)";
            stm.executeUpdate(sql);
            stm.executeUpdate("INSERT INTO Jogadores (Registo,Pontuacao) VALUES ('Neiva','33')");
            stm.executeUpdate("INSERT INTO Jogadores (Registo,Pontuacao) VALUES ('Mauricio','31')");
            stm.executeUpdate("INSERT INTO Jogadores (Registo,Pontuacao) VALUES ('Luis','33')");

        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static JogadorDAO getInstance() {
        if (JogadorDAO.singleton == null) {
            JogadorDAO.singleton = new JogadorDAO();
        }
        return JogadorDAO.singleton;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Jogador get(Object key) {
        return null;
    }

    @Override
    public Jogador put(String key, Jogador value){
        Campeonato campeonato = null;

        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("INSERT INTO Jogadores (Registo,Pontuacao VALUES ('Neiva','33')");
            stm.executeUpdate("INSERT INTO Jogadores (Registo,Pontuacao VALUES ('Mauricio','31')");
            stm.executeUpdate("INSERT INTO Jogadores (Registo,Pontuacao VALUES ('Luis','33')");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return null;
    }

    @Override
    public Jogador remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Jogador> m) {

    }


    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Jogador> values() {
        Collection<Jogador> jogadores = new ArrayList<>();
        try {
            Connection conn = DAOconfig.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT Registo FROM Jogadores");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
               Jogador c = new Jogador(rs.getString("Registo"));
               jogadores.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogadores;
    }

    @Override
    public Set<Entry<String, Jogador>> entrySet() {
        return null;
    }

    @Override
    public void clear() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("DELETE FROM Jogadores");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
}