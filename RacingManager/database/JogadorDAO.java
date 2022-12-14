package RacingManager.database;

import RacingManager.business.Jogador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class JogadorDAO implements Map<String, Jogador> {

    private static JogadorDAO singleton = null;

    private JogadorDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS jogador (" +
                    "registo varchar(10) NOT NULL PRIMARY KEY," +
                    "pontuação int(4) DEFAULT 0," +
                    "CarroId varchar(10)," +
                    "foreign key (CarroId) references carro(IDCarro))";
            stm.executeUpdate(sql);
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
    public Jogador put(String key, Jogador value) {
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
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Jogador> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Jogador>> entrySet() {
        return null;
    }
}