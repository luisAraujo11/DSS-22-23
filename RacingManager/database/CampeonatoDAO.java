package RacingManager.database;


import RacingManager.Campeonato.Campeonato;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CampeonatoDAO implements Map<Integer, Campeonato> {
    private static CampeonatoDAO singleton = null;

    private CampeonatoDAO() {
        try (
                Connection conn = DAOconfig.getConnection();
                Statement stm = conn.createStatement();
        ) {
            String sql = "CREATE TABLE IF NOT EXISTS championships (" +
                    "Nome VARCHAR(255) PRIMARY KEY," +
                    ");";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static CampeonatoDAO getInstance() {
        if (singleton==null)
            singleton=new CampeonatoDAO();
        return singleton;
    }

    @Override
    public int size() {
        int i = 0;
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Campeonatos;");){
            if (rs.next())
                i = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof Integer)) return false;
        boolean r=false;
        try (Connection conn = DAOconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT Nome FROM Campeonatos WHERE Nome= ?;");){
            ps.setInt(1,(Integer) key);
            try (ResultSet rs = ps.executeQuery();){
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
            ps.setInt(1,(Integer)key);
            try (ResultSet rs = ps.executeQuery();){

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public Campeonato put(Integer key, Campeonato value) {
        String sql = "";
     {
            sql = "INSERT INTO championships (Nome) VALUES (?,?);";
        }
        try (Connection conn = DAOconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
        } catch (SQLException e) {
            return null;
        }
    return null;}



    @Override
    public Campeonato remove(Object key) {
        Campeonato cha = get(key);
        if (cha == null)
            return null;
        try (Connection conn = DAOconfig.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM Campeonatos WHERE Id = ?;");
        ) {
            ps.setInt(1, (int) key);
            ps.executeUpdate();
            return cha;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Campeonato> m) {

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
    public Set<Integer> keySet() {
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
    }


    @Override
    public Collection<Campeonato> values() {
        Collection<Campeonato> r = new HashSet<Campeonato>();
        try (Connection conn = DAOconfig.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT Id FROM Campeonatos;");
        ) {
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    @Override
    public Set<Entry<Integer, Campeonato>> entrySet() {
        return null;
    }


    @Override
    public Campeonato getOrDefault(Object key, Campeonato defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super Integer, ? super Campeonato> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super Integer, ? super Campeonato, ? extends Campeonato> function) {
        Map.super.replaceAll(function);
    }

    @Override
    public Campeonato putIfAbsent(Integer key, Campeonato value) {
        return Map.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    @Override
    public boolean replace(Integer key, Campeonato oldValue, Campeonato newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    @Override
    public Campeonato replace(Integer key, Campeonato value) {
        return Map.super.replace(key, value);
    }

    @Override
    public Campeonato computeIfAbsent(Integer key, Function<? super Integer, ? extends Campeonato> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Campeonato computeIfPresent(Integer key, BiFunction<? super Integer, ? super Campeonato, ? extends Campeonato> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public Campeonato compute(Integer key, BiFunction<? super Integer, ? super Campeonato, ? extends Campeonato> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    @Override
    public Campeonato merge(Integer key, Campeonato value, BiFunction<? super Campeonato, ? super Campeonato, ? extends Campeonato> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }
}
/*
import RacingManager.Campeonato.Campeonato;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CampeonatoDAO implements Map<String, Campeonato> {

    private static CampeonatoDAO singleton = null;
    //private static CircuitoDAO singleton = null;

    private CampeonatoDAO() { // TODO mudar o sql do campeonato
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS circuito (" +
                    "Nome varchar(10) NOT NULL PRIMARY KEY," +
                    "Distancia int(4) DEFAULT 0," +
                    "Curvas int(4) DEFAULT 0," +
                    "Chicane int(4) DEFAULT 0," +
                    "Voltas int(4) DEFAULT 0," +
                    "CarroID varchar(10) NOT NULL)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS campeonato (" +
                    "Nome varchar(10) NOT NULL)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS gdu (" +
                    "Tempo varchar(10) NOT NULL PRIMARY KEY," +
                    "Piloto varchar(10) DEFAULT NULL," +
                    "Carro varchar(10) NOT NULL)";
            stm.executeUpdate(sql);
            sql= "CREATE TABLE IF NOT EXISTS record (" +
                    "Piloto varchar(45) NOT NULL PRIMARY KEY," +
                    "Tempo float(8) ," +
                    "Carro varchar(45) DEFAULT NULL)";
            sql = "CREATE TABLE IF NOT EXISTS carro (" +
                    "IdCarro int(10) DEFAULT 0 PRIMARY KEY," +
                    "Marca varchar(45) DEFAULT NULL," +
                    "Modelo varchar(45) DEFAULT NULL," +
                    "Cilindrada int(4) DEFAULT 0," +
                    "Potencia int(4) DEFAULT 0," +
                    "PotenciaEletrica int(4) DEFAULT 0," +
                    "SerHibrido BIT(2)," +
                    "Pac FLOAT(8))";
            sql = "CREATE TABLE IF NOT EXISTS corrida (" +
                    "IdCorrida varchar(10) NOT NULL PRIMARY KEY)";
            //  "CircuitoId varchar(10),  foreign Key(CircuitoId) references circuito(Nome)" +
            //  "MetereologiaId varchar(10), foreign Key(MetereologiaId) references metereologia(IdMet))";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS metereologia (" +
                    "IdMet varchar(10) NOT NULL PRIMARY KEY," +
                    "Temperatura int(4)," +
                    "Precipitação int(4))";
            stm.executeUpdate(sql);
            stm.executeUpdate(sql);
            stm.executeUpdate("INSERT INTO circuito VALUES ( 'Marhnaz', 12, 25,13,14,'Magyhnaz')");
           // stm.executeUpdate("INSERT INTO gdu VALUES (1, 'Mahndaz','Mahfnaz')");
            stm.executeUpdate("INSERT INTO record VALUES ('Madhnaz', 12.2 ,'Mahfnaz')");
            stm.executeUpdate("INSERT INTO carro VALUES (2,'Mashnaz','Mahgnaz',6,8,,5,0,2)");
           // stm.executeUpdate("INSERT INTO carro VALUES (2,'Mahnaz','Mahnaz',6,8,,5,0, 12.2)");
           // stm.executeUpdate("INSERT INTO metereologia VALUES()")



        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }


    public static CampeonatoDAO getInstance() {
        if (CampeonatoDAO.singleton == null) {
            CampeonatoDAO.singleton = new CampeonatoDAO();
        }
        return CampeonatoDAO.singleton;
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
    public Campeonato get(Object key) {
        return null;
    }

    @Override
    public Campeonato put(String key, Campeonato value) {
        return null;
    }

    @Override
    public Campeonato remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Campeonato> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Campeonato> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Campeonato>> entrySet() {
        return null;
    }
}
*/
