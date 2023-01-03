package RacingManager.database;

import RacingManager.business.Corrida.Corrida;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CorridaDAO implements Map<String, Corrida> {

    private static CorridaDAO singleton = null;

    private CorridaDAO() { // TODO mudar o sql do corrida
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS campeonato (" +
                    "registo varchar(10) NOT NULL PRIMARY KEY," +
                    "pontuação int(4) DEFAULT 0," +
                    "CarroId varchar(10))";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static CorridaDAO getInstance() {
        if (CorridaDAO.singleton == null) {
            CorridaDAO.singleton = new CorridaDAO();
        }
        return CorridaDAO.singleton;
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
    public Corrida get(Object key) {
        return null;
    }

    @Override
    public Corrida put(String key, Corrida value) {
        return null;
    }

    @Override
    public Corrida remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Corrida> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Corrida> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Corrida>> entrySet() {
        return null;
    }
}