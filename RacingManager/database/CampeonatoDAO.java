package RacingManager.database;


import RacingManager.business.Campeonato.Campeonato;
import RacingManager.business.Campeonato.CampeonatoFacade;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CampeonatoDAO implements Map<String, Campeonato> {
    private static CampeonatoDAO singleton = null;

    private CampeonatoDAO() throws SQLException {
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();) {
            String sql = "CREATE TABLE IF NOT EXISTS Campeonatos (" +
                    "Nome VARCHAR(255) DEFAULT NULL PRIMARY KEY)";
            //stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    /**
     * Implementação do padrão Singleton
     *
     * @return devolve a instância única desta classe
     */
    public static CampeonatoDAO getInstance() throws SQLException {
        if (CampeonatoDAO.singleton == null)
            CampeonatoDAO.singleton = new CampeonatoDAO();
        return CampeonatoDAO.singleton;
    }

    @Override
    public int size() {
        int i = 0;
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Campeonatos;");) {
            if (rs.next())
                i = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof Integer)) return false;
        boolean r = false;
        try (Connection conn = DAOconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT Nome FROM Campeonatos WHERE Nome= ?;");) {
            ps.setInt(1, (Integer) key);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next())
                    r = true;
            }
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

    @Override
    public boolean containsValue(Object value) {
        if (!(value instanceof Campeonato)) return false;
        Campeonato p = (Campeonato) value;
        return p.equals(get(p.getNome()));
    }

    @Override
    public Campeonato get(Object key) {
        if (!(key instanceof Integer)) return null;
        try (Connection conn = DAOconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT Nome FROM Campeonatos WHERE Nome= ?;");
        ) {
            ps.setInt(1, (Integer) key);
            try (ResultSet rs = ps.executeQuery();) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Campeonato put(String key, Campeonato value) {
        Campeonato campeonato = null;

        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("INSERT INTO Campeonatos VALUES ('" + value.getNome() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return null;
    }


    @Override
    public Campeonato remove(Object key) {
        Campeonato cha = get(key);
        if (cha == null)
            return null;
        try (Connection conn = DAOconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM Campeonatos WHERE Nome = ?;");
        ) {
            ps.setInt(1, (int) key);
            ps.executeUpdate();
            return cha;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Campeonato> m) {

    }


    @Override
    public void clear() {
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();
        ) {
            stm.executeUpdate("DELETE FROM Campeonatos;");
        } catch (SQLException e) {
            throw new RuntimeException(e);//TODO MUDAR ISTO
        }
    }

    @Override
    public Set<String> keySet() {
        return null;
    }

/*
    @Override
    public Set<String> keySet() {
        Set<Integer> r = new HashSet<>();
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT Id FROM Campeonatos;");
        ) {
            while (rs.next())
                r.add(rs.getInt(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return r;
    }*/


    @Override
    public Collection<Campeonato> values() {
        Collection<Campeonato> r = new HashSet<Campeonato>();
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT Nome FROM Campeonatos;");
        ) {
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    @Override
    public Set<Entry<String, Campeonato>> entrySet() {
        return null;
    }


    @Override
    public Campeonato getOrDefault(Object key, Campeonato defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }


    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }


}
