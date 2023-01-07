package RacingManager.database;


import RacingManager.business.Campeonato.Campeonato;
import RacingManager.business.Corrida.Acontecimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CampeonatoDAO implements Map<String, Campeonato> {
    private static CampeonatoDAO singleton = null;

    private CampeonatoDAO() throws SQLException {
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();) {

            //clear();
            String sql = "CREATE TABLE IF NOT EXISTS Campeonatos (" +
                    "Nome varchar(10) NOT NULL PRIMARY KEY)";
            stm.executeUpdate(sql);

            /*
            sql = "CREATE TABLE IF NOT EXISTS Pilotos (" +
                    "Nome varchar(10) NOT NULL PRIMARY KEY," +
                    "cts varchar(10) DEFAULT NULL, " +
                    "sva varchar(10) DEFAULT NULL)";

            stm.executeUpdate(sql);


            stm.executeUpdate("INSERT INTO Pilotos (Nome,cts,sva) VALUES ('Neiva','33','23')");
            stm.executeUpdate("INSERT INTO Pilotos (Nome,cts,sva) VALUES ('Mauricio','33','23')");
            stm.executeUpdate("INSERT INTO Pilotos (Nome,cts,sva) VALUES ('Luis','33','23')");

    */
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
        Campeonato c = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM Campeonatos WHERE Nome='"+key+"'")){
                if (rs.next()) {  // A chave existe na tabela
                    // Reconstruir a colecção de campeonatos
                    c = new Campeonato(rs.getString("Nome"));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;

    }
    @Override
    public Collection<Campeonato> values() {
                                Collection<Campeonato> campeonatos = new ArrayList<>();
                                try {
                                    Connection conn = DAOconfig.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT Nome FROM Campeonatos");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
        Campeonato c = new Campeonato(rs.getString("Nome"),CircuitoDAO.getCircuitos());
        campeonatos.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return campeonatos;
    }

    public Campeonato putAll() {
        Campeonato c = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM campeonatos")){
            if (rs.next()) {  // A chave existe na tabela
                // Reconstruir a colecção de campeonatos
                c = new Campeonato(rs.getString("Nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }


/*
    public ArrayList<String> getCampeonatos(Statement stm) throws SQLException {
        ArrayList<String> campeonatos = new ArrayList<>();
        try (ResultSet rsa = stm.executeQuery("SELECT Nome FROM Campeonatos")) {
            while(rsa.next()) {
                campeonatos.add(rsa.getString("Nome"));
            }
        } // execepção é enviada a quem chama o método - este try serve para fechar o ResultSet automaticamente
        return campeonatos;
    }
    
*/

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
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("DELETE FROM Campeonatos");
            stm.executeUpdate("DELETE FROM Pilotos");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
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
